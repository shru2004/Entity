package com.utf3164.fahrenheit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {

	@Id
	@SequenceGenerator(
			name = "provider_seq_id", 
			sequenceName = "provider_seq_id", 
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "provider_seq_id"
			)

	private Long providerId;
	private String firstName;
	private String lastName;
	private Integer yearOfExperience;
	private Integer rating;
	private Float npi;
}
