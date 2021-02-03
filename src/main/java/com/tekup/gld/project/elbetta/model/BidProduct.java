package com.tekup.gld.project.elbetta.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "bidProduct")
public class BidProduct extends Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String model;
	
	private String specification;
	
	private float starPrice;
	
	//de type user
	private String higherBidder;
	
	private Float currentPrice;


}
