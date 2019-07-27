package com.lendico.exam.schedule.repayment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.exam.schedule.repayment.model.PaymentRequest;
import com.lendico.exam.schedule.repayment.model.PaymentResponse;
import com.lendico.exam.schedule.repayment.service.RepaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class is responsible for expsoing rest service for getting Annuity loan repayment schedule.
 * @author Sougata Maitra
 * @version 1.0
 *
 */
@Api(consumes="application/json",produces="application/json")

@RestController

public class RePaymentScheduleController {
	
	@Autowired
	RepaymentService replaymentService;
	
	@ApiOperation(value = "Fetches list of repayment schedule for annuity loan",responseContainer = "List", response = PaymentResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 500, message = "Internal Server Error"),
	        @ApiResponse(code = 400, message = "Bad Request"),
	        @ApiResponse(code = 400, message = "Not Found")
	})
	
	@PostMapping(value="/replaymentschudele", produces = { MediaType.APPLICATION_JSON_VALUE },consumes={MediaType.APPLICATION_JSON_VALUE})
	public List<PaymentResponse> getPaymentInformation(@Valid @RequestBody PaymentRequest paymentRequest) {
		return replaymentService.getReplaymentSchedule(paymentRequest);
	}

}
