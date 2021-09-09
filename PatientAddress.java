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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientAddress {

	@Id
	@SequenceGenerator(
			name = "patientAddress_sequence", 
			sequenceName = "patientAddress_sequence", 
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "patientAddress_sequence"
	)
	
	private Long patientAddressId;
	private String address1;
	private String address2;
	private String street;
	private String city;
	private String state;
	private Long zip_code;
}
