package com.tekup.gld.project.elbetta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	private static final long serialVersionUID = -7384470937964519004L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

	private LocalDate dateOfBirth;

	// Comma separated list of roles
	@Column(name = "roles")
	private String roles;
	@Column(name = "active")
	private Boolean active;
	private String TelephoneNumber;
	/*@Column(name = "address")
	@OneToMany
	private List <Address> address;
	@Column(name = "gender")
	private String gender;
	/*@Column(name="infoBancaire")
	@OneToMany(cascade = CascadeType.ALL)
	private InfoBancaire info;*/

}

