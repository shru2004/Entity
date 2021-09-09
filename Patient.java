package com.utf3164.fahrenheit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Patient {

	@Id
	@SequenceGenerator(
			name = "patient_seq_id",
			sequenceName = "patient_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "patient_seq_id"
			)
	private Long patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private String maritalStatus;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "patientId",
			referencedColumnName = "patientId"
			)
	
	private List<PatientAddress> patientAddress;
	
}
