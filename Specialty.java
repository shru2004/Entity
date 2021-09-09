package com.utf3164.fahrenheit.entity;

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
public class Specialty {

	@Id
	@SequenceGenerator(
			name = "specialityId_sequence", 
			sequenceName = "specialityId_sequence", 
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "specialityId_sequence"
			)
	
	private Long specialityId;
	private String name;
	
	// provider Specialty
	@ManyToMany
	@JoinTable(
			name = "ProviderSpeciality", 
			joinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "specialityId"), 
			inverseJoinColumns = @JoinColumn(name = "provider_id ", referencedColumnName = "providerId")
			)
	private java.util.List<Provider> provider;
	
}
