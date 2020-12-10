package com.tekup.gld.project.elbetta.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

	private String name;
	
	private String description;

}
