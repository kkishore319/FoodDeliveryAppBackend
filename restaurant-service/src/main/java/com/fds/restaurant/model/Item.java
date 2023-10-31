package com.fds.restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Item {
	
	@Id
	private String itemId;
	private String restaurantId;
	private String itemName;
	private String category;
	private String description;
	private double price;
	private String image;

}
