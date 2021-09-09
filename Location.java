package com.utf3164.fahrenheit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

	@Id
	@SequenceGenerator(
			name = "location_seq_id",
			sequenceName = "location_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "location_seq_id"
			)
	private Long locationId;
	private String name;
	
	
	@OneToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "addressId",
			referencedColumnName = "addressId"
			)
	private Address address;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "locationId",
			referencedColumnName = "locationId"
			)
	private List<LocationContact> locationContact;
	
	
}
