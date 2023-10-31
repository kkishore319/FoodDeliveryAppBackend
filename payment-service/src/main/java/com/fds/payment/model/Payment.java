package com.fds.payment.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Payment {

	@Id
	private long transactionId;
	private int orderId;
	private Date paymentDate;
	private String username;
	//private String paymentLocation;
	private double amount;
	private String transactionStatus;
}

