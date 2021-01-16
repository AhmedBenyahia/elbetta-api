package com.tekup.gld.project.elbetta.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "users")
public class User {

	private static final long serialVersionUID = -7384470937964519004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	private String password;

	private LocalDate dateOfBirth;

	// Comma separated list of roles
	private String roles;

	private Boolean active;

	private String telephoneNumber;

	@JoinColumn(name = "user_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Address.class)
	private Set<Address> address;


	@JoinColumn(name = "user_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = InfoBancaire.class)
	private Set<InfoBancaire> infoBanks;

}

