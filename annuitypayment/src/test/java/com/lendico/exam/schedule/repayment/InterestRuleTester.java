package com.lendico.exam.schedule.repayment;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lendico.exam.schedule.repayment.rule.InterestRule;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InterestRuleTester {
	
	@Autowired
	InterestRule interestRule;
	
	@Test
	public void testcalculateInerestPerPeriod() {
		double loanAmout = 5000;
		double nominalInterestRate = 5;
		double loanAmount = interestRule.calculateInerestPerPeriod(loanAmout, nominalInterestRate);
		loanAmount = new BigDecimal(loanAmount).setScale(2,RoundingMode.HALF_UP).doubleValue();
		assertTrue(loanAmount==20.83);
	}
}
