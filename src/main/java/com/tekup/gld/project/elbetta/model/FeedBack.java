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
@Table(name = "feedbacks")
@NoArgsConstructor
@AllArgsConstructor


public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate date;
	private String description;
	private int score;


}
