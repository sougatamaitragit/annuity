package com.lendico.exam.schedule.repayment.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendico.exam.schedule.repayment.model.PaymentRequest;
import com.lendico.exam.schedule.repayment.model.PaymentResponse;
import com.lendico.exam.schedule.repayment.rule.AnnutiyRule;
import com.lendico.exam.schedule.repayment.rule.InterestRule;
import com.lendico.exam.schedule.repayment.util.LoanRepaymentUtil;
import com.lendico.exam.schedule.repayment.util.RoundingUtils;

@Service
public class RepaymentService {
	@Autowired
	AnnutiyRule annuityRule;
	
	@Autowired
	InterestRule interestRule;
	
	/**
	 * This method calculates payment schedule , annuity , outstanding amount , principal and interest amount for an annuity loan. 
	 * @param paymentRequest
	 * @return List<PaymentResponse>
	 */
	
	public List<PaymentResponse> getReplaymentSchedule(PaymentRequest paymentRequest){
		int loanDuration = paymentRequest.getDuration();
		List<PaymentResponse> paymentResponseList = new ArrayList<>();
		
		double initialOutStandingAmount = paymentRequest.getLoanAmount();
		
		double annuity = annuityRule.caluclateAnnuity
				(initialOutStandingAmount, paymentRequest.getNominalRate()/
							LoanRepaymentUtil.NUMBER_OF_MONTHS_IN_YEAR, paymentRequest.getDuration());
		annuity 	   = RoundingUtils.roundToNDecimalPlace
				(annuity, LoanRepaymentUtil.ROUND_OFF_PLACE);

		
		for(int i=1;i<=loanDuration;i++) {
			PaymentResponse paymentResponse = new PaymentResponse();
			
			double interestAmount = interestRule.calculateInerestPerPeriod
											(initialOutStandingAmount, paymentRequest.getNominalRate());
			
			
			interestAmount = RoundingUtils.roundToNDecimalPlace
										(interestAmount, LoanRepaymentUtil.ROUND_OFF_PLACE);
			
			if( interestAmount > initialOutStandingAmount ) {
				interestAmount = initialOutStandingAmount;
				
			}
			
			double principalAmount = annuity - interestAmount;
			principalAmount = RoundingUtils.roundToNDecimalPlace(principalAmount, LoanRepaymentUtil.ROUND_OFF_PLACE);
			
			// During last month principal amount may need to be corrected , since one cannot repay more principal than acutal principal amount hence
			
			if(principalAmount > initialOutStandingAmount) {
				principalAmount = initialOutStandingAmount;
				annuity = principalAmount + interestAmount;
			}
			
			paymentResponse.setPrincipal(principalAmount);
			paymentResponse.setInitialOutstandingPrincipal(initialOutStandingAmount);
			double remainingAmount = initialOutStandingAmount - principalAmount;
			remainingAmount= RoundingUtils.roundToNDecimalPlace
					(remainingAmount, LoanRepaymentUtil.ROUND_OFF_PLACE);
			paymentResponse.setInterest(interestAmount);
			paymentResponse.setBorrowerPaymentAmount(annuity);
			paymentResponse.setRemainingOutstandingPrincipal(remainingAmount);
			Calendar cal = Calendar.getInstance();
			cal.setTime(paymentRequest.getStartDate());
			cal.add(Calendar.MONTH, i-1);
			paymentResponse.setDate(cal.getTime());
			paymentResponseList.add(paymentResponse);
			initialOutStandingAmount =remainingAmount;
			
		}
		return paymentResponseList;
		
	}

}
