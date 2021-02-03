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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

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

	@JoinColumn(name = "owner_id")
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Store> stores;

	public User(Long id) {
		this.id = id;
	}
}

