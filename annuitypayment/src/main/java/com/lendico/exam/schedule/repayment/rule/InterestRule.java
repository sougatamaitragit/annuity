package com.lendico.exam.schedule.repayment.rule;

import org.springframework.stereotype.Component;

import com.lendico.exam.schedule.repayment.util.LoanRepaymentUtil;

/**
 * This class is responsible for calculating Interest based on borrowed amount  
 * It calculates interest rate based on Present Value , interest per period , number of periods
 * @author Sougata Maitra
 * @version 1.0
 *
 */
@Component
public class InterestRule {
	/**
	 * This method calculates interest amount in Euro . Based on Current loan amount and yearly nominal interest rate its calculates monthly interest amount  
	 * @param loanAmout
	 * @param nominalInterestRate
	 * @return
	 */
	
	public double calculateInerestPerPeriod(double loanAmount,double nominalInterestRate ) {
		double interestAmount =  (loanAmount*LoanRepaymentUtil.NUMBER_OF_DAYS_IN_MONTH*nominalInterestRate)/(LoanRepaymentUtil.NUMBER_OF_DAYS_IN_YEAR*100);
		return interestAmount;
		
	}

}
