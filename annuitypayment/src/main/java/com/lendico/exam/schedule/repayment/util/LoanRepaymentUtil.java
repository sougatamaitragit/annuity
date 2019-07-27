package com.lendico.exam.schedule.repayment.util;

/**
 * This interface defines constants used in payment calculation.
 * @author Sougata Maitra
 * @version 1.0
 */
public interface LoanRepaymentUtil {
	/*
	 * This variable defines number of days in a Months. For the simplicity it is decided to take 30 days per month.
	 */
	public final int  NUMBER_OF_DAYS_IN_MONTH      = 30;
	/*
	 * This variable defines number of days in a year . For the simplicity it is decided to take 360 days per year.
	 */
	public final int  NUMBER_OF_DAYS_IN_YEAR       = 360;
	/*
	 * This variable defines number of months in a year.
	 */
	public final int  NUMBER_OF_MONTHS_IN_YEAR     = 12;
	
	/*
	 * This variable defines round off places after decimal.
	 */
	public final int  ROUND_OFF_PLACE               = 2;
	
	/*
	 * This defines Generic Server Error Message.
	 */
	public final String  SERVER_ERROR               = "Server Error Occured";


}
