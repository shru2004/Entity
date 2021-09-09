package com.utf3164.fahrenheit.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class PatientContact {

	@Id
	@SequenceGenerator(
			name = "patient_contact_seq_id",
			sequenceName = "patient_contact_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "patient_contact_seq_id"
			)
	private Long PatientContactId;
	
	@OneToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "patientId",
			referencedColumnName = "patientId"
			)
	
	private Patient patient;
	
	
}
