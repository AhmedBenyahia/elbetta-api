package com.tekup.gld.project.elbetta.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "info_bancaire")
public class InfoBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;



}
