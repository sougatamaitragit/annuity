package com.lendico.exam.schedule.repayment.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents Borrow's payment request information. 
 * Borrower will able to find payment schedule and amount information based on loan amount , nominal rate ,duration , loan start date
 * @author Sougata Maitra
 * @version 1.0
 */
public class PaymentRequest {
		
	@ApiModelProperty(notes = "Annuity loan Amount",required=true,dataType="Double")
	@NotNull(message="loan amount cannot be null")
	Double loanAmount;
	
	@ApiModelProperty(notes = "Nominal interest rate per year",required=true,dataType="Double")
	@NotNull(message="nominal interest rate cannot be null")
	Double nominalRate;
	
	@ApiModelProperty(notes = "Duration of loan in months",required=true,dataType="Integer")
	@Min(1)
	int duration;
	
	@ApiModelProperty(notes = "Payment start date ",required=true,dataType="Date",example="2018-01-01T00:00:01Z")
	@NotNull(message="start date cannot be null and must be in proper date format")
	Date startDate;
	
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getNominalRate() {
		return nominalRate;
	}
	public void setNominalRate(Double nominalRate) {
		this.nominalRate = nominalRate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	

}
