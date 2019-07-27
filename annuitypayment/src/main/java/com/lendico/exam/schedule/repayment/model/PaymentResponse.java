package com.lendico.exam.schedule.repayment.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * This Model represent Borrower's payment schedule , outstanding amount, principal amount , interest amount
 * and remaining out standing amount
 * @author Sougata Maitra
 * @version 1.0
 */
public class PaymentResponse {
	
	@ApiModelProperty(notes = "Amount borrower need to day each month",required=true,dataType="Double")
	Double borrowerPaymentAmount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@ApiModelProperty(notes = "Payment date",dataType="date" , example="2018-02-01T00:00:01Z")
	Date date;
	
	@ApiModelProperty(notes = "Initial Outstanding Principal Amount",dataType="Double")
	Double initialOutstandingPrincipal;
	
	@ApiModelProperty(notes = "Interest Amount payable",required=true,dataType="Double")
	Double interest;
	@ApiModelProperty(notes = "Principal Amount Payable",required=true,dataType="Double")
	Double principal;
	
	@ApiModelProperty(notes = "Remaining Principal Amount",required=true,dataType="Double")
	Double remainingOutstandingPrincipal;
	
	
	public Double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	public void setBorrowerPaymentAmount(Double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	public void setInitialOutstandingPrincipal(Double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	public void setRemainingOutstandingPrincipal(Double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
	
	

}
