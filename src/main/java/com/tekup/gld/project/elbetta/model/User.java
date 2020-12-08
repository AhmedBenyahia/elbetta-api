package com.tekup.gld.project.elbetta.model;

import javax.persistence.Column;
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

	@JoinColumn(name = "user_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Address.class)
	private Set<Address> address;

//	@Column(name = "gender")
//	private String gender;

	@JoinColumn(name = "user_id")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = InfoBancaire.class)
	private Set<InfoBancaire> infoBanks;

}

