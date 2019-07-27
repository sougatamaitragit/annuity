package com.lendico.exam.schedule.repayment;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lendico.exam.schedule.repayment.model.PaymentRequest;
import com.lendico.exam.schedule.repayment.model.PaymentResponse;
import com.lendico.exam.schedule.repayment.service.RepaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepaymentServiceTester {
	
	
	@Autowired
	RepaymentService repaymentService ;
	
	@Test
	public void testRepaymentService() throws ParseException {
		
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setDuration(24);
		paymentRequest.setLoanAmount(5000d);
		paymentRequest.setNominalRate(5.0);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy'T'00:00:00'Z'");
		String dateString = "05-01-2019T00:00:00Z";
		Date startDate = format.parse(dateString);
		
		paymentRequest.setStartDate(startDate);
		List<PaymentResponse> paymentResponseList=	repaymentService.
														getReplaymentSchedule(paymentRequest);
		assertTrue(paymentResponseList.size()==24);
		PaymentResponse paymentResponse = paymentResponseList.get(0);
		assertTrue(paymentResponse.getInitialOutstandingPrincipal()==5000);
		assertTrue(paymentResponse.getPrincipal()==198.53);
		assertTrue(paymentResponse.getRemainingOutstandingPrincipal()==4801.47);
		
		PaymentResponse paymentResponseNextMonth = paymentResponseList.get(2);
		Date nextDate = format.parse("05-03-2019T00:00:00Z");
		assertTrue(paymentResponseNextMonth.getDate().compareTo(nextDate)==0);
		PaymentResponse paymentResponseLast = paymentResponseList.get(23);
		assertTrue(paymentResponseLast.getRemainingOutstandingPrincipal()==0);
		
	}

}
