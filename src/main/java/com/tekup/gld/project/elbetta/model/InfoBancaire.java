package com.tekup.gld.project.elbetta.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="infoBancaire")
public class InfoBancaire {
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="id")
	 private Long id;
	 
	 private String pays;
	 private String typePaiment;
	 private Integer NumeroCard;
	 private LocalDate ExpireDate;
	 private String FirstName;
	 private String LastName;
	 private Integer postalCode;
	 private String homePhone;
	 private String email; 
	 /*@Column(name="user")
     private User user;*/
     
 
 
 

}
