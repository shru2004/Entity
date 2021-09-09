package com.utf3164.fahrenheit.entity;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Appointment {

	@Id
	@SequenceGenerator(
			name = "appointment_sequence", 
			sequenceName = "appointment_sequence", 
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "appointment_sequence"
			)
	
	private Long appointmentId;
	private String status;
	private Timestamp createdTs;
	private String createdBy;
	private Timestamp updateTs;
	private String updatedBy;
	private Long appointmentReferenceId;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn( 
			name = "patientId",
			referencedColumnName = "patientId"
			)
	
	private Patient patient;

}

