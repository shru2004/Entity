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
public class Contact {

	@Id
	@SequenceGenerator(
			name = "contact_seq_id",
			sequenceName = "contact_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "contact_seq_id"
			)
	private Long contactId;
	private String name;
	private String value;
	private String type;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "contactId",
			referencedColumnName = "contactId"
			)
	private List<PatientContact> patientContact;
	
	
}
