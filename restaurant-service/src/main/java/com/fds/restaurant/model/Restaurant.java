package com.fds.restaurant.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Restaurant {
	@Id
	private String restaurantId;
	private String restaurantName;
	private int rating;
	private String type;
	private String location;
//	private List<Item> items;

}
