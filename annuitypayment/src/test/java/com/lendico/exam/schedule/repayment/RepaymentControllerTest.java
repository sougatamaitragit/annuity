package com.lendico.exam.schedule.repayment;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.lendico.exam.schedule.repayment.model.PaymentRequest;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepaymentControllerTest {
	

	@LocalServerPort
	private int port;
	
	
	@Test
	public void paymentScheduleTest() {
		PaymentRequest input = new PaymentRequest();
		input.setDuration(24);
		input.setLoanAmount(5000d);
		input.setNominalRate(5.0);
		input.setStartDate(new Date());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeader = new HttpHeaders();
		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(input, httpHeader);
		
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("/replaymentschudele"),
				HttpMethod.POST, entity, List.class);
		
		HttpStatus status = response.getStatusCode();
		assertTrue(status.value()==200);
		List bodyList = response.getBody();
		assertTrue(bodyList.size()==24);
		
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
