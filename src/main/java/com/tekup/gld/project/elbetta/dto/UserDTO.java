package com.tekup.gld.project.elbetta.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import com.tekup.gld.project.elbetta.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
 
	private String username;

	private String password;
	
	private LocalDate dateOfBirth;

	private String roles;

	private Boolean active;
  
	private String TelephoneNumber;




}
