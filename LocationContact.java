package com.utf3164.fahrenheit.entity;

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
public class LocationContact {

	@Id
	@SequenceGenerator(
			name = "location_contact_seq_id",
			sequenceName = "location_contact_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "location_contact_seq_id"
			)
	private Long locationContactId;
	private Integer active;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "contactId",
			referencedColumnName = "contactId"
			)
	private Contact contact;
}
