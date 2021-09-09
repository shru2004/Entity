package com.utf3164.fahrenheit.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PracticeContact {

	@Id
	@SequenceGenerator(
			name = "practice_contact_seq_id",
			sequenceName = "practice_contact_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "practice_contact_seq_id"
			)
	private Long practiceContactId;

	private Integer active;
	
	@OneToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "practiceId",
			referencedColumnName = "practiceId"
			)
	
	private Practice practice;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "contactId",
			referencedColumnName = "contactId"
			)
	
	private Contact contact;
}
