package com.lendico.exam.schedule.repayment.rule;

import org.springframework.stereotype.Component;

/**
 * This class is responsible for calculating Annuity amount for annuity loans. 
 * It calculates annuity based on Present Value , interest per period , number of periods
 * @author Sougata Maitra
 * @version 1.0
 *
 */
@Component
public class AnnutiyRule {
	/**
	 * This method calculates Annuity based on present value , interest period and number of periods. This methods approximates upto 2 decimal places.
	 * @param presentValue
	 * @param interestPerPeriod
	 * @param numberOfPeriods
	 * @return
	 */
	public Double caluclateAnnuity(double presentValue,double interestPerPeriod,int numberOfPeriods) {
		double annuity = 0d;
		interestPerPeriod = (interestPerPeriod/100);
		annuity =  ((interestPerPeriod)*presentValue)/ (1- Math.pow((1+interestPerPeriod), -numberOfPeriods));
		return annuity;
	}

}
