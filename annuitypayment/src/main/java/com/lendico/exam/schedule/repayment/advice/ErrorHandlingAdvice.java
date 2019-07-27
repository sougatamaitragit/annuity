package com.lendico.exam.schedule.repayment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lendico.exam.schedule.repayment.error.ApiError;
import com.lendico.exam.schedule.repayment.util.LoanRepaymentUtil;
import org.springframework.web.bind.MethodArgumentNotValidException;
/**
 * This class is responsible for handling all un-handled runtime exceptions and log the exection 
 * Currently log-file is not configured so stacktrace is printed
 * @author Sougata Maitra
 * @version 1.0
 */

@ControllerAdvice
public class ErrorHandlingAdvice {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApiError  genericException(Exception ex) {
		ex.printStackTrace();
		ApiError res = new ApiError();
		res.setErrorMessage(LoanRepaymentUtil.SERVER_ERROR);
		return res;
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError inputvalidatefaied(MethodArgumentNotValidException ex) {
		ex.printStackTrace();
		ApiError res = new ApiError();
		res.setErrorMessage(ex.getMessage());
		return res;
		
		
	}
	
	

}
