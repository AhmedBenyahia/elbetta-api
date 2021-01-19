package com.tekup.gld.project.elbetta.model;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "product")
public class PromCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	
	private String code;
	//creationdate de recipe
	private LocalDate creationDate;
	
	private LocalDate expirationDate;
	
	private boolean isRedeem;

}
