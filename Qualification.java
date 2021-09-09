package com.utf3164.fahrenheit.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Qualification {
	
		@Id
		@SequenceGenerator(
				name = "qualificationId_sequence", 
				sequenceName = "qualificationId_sequence",
				allocationSize = 1
		)
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE, 
				generator = "qualificationId_sequence"
				)
		
		private Long qualificationId;
		private String name;

		// provider Qualification
		@ManyToMany
		@JoinTable(
				name = "ProviderQualification", 
				joinColumns = @JoinColumn(name = "qualification_Id", referencedColumnName = "qualificationId"), 
				inverseJoinColumns = @JoinColumn(name = "provider_id ", referencedColumnName = "providerId")
				)
		private List<Provider> provider;

	}

