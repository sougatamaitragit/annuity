package com.lendico.exam.schedule.repayment;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lendico.exam.schedule.repayment.rule.AnnutiyRule;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AnnuityRuleTester {
	
	@Autowired
	AnnutiyRule annuityRule;
	
	@Test
	public void caluclateAnnuity() {
		double loanAmount = 5000d;
		int numberOfPeriods = 24;
		double interestPerPeriod = (5.0/12);
		double annuityAmount = annuityRule.caluclateAnnuity(loanAmount, interestPerPeriod, numberOfPeriods);
		annuityAmount = new BigDecimal(annuityAmount).setScale(2,RoundingMode.HALF_UP).doubleValue();
		assertTrue(annuityAmount==219.36);
	}
	

}
