package com.tekup.gld.project.elbetta.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -1116456003436530965L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Column(name = "username", length = 50, nullable = false)
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;
	// Comma separated list of roles
	@Column(name = "roles")
	private String roles;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "TelephoneNumber")
	private String TelephoneNumber;
	/*@Column(name = "address")
	@OneToMany
	private List <Address> address;
	@Column(name = "gender")
	private String gender;
	/*@Column(name="infoBancaire")
	@OneToMany(cascade = CascadeType.ALL)
	private InfoBancaire info;*/
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	


}

