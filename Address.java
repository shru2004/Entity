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
public class Address {

	@Id
	@SequenceGenerator(
			name = "address_seq_id",
			sequenceName = "address_seq_id",
			allocationSize = 1
			)
	@GeneratedValue( 
			strategy = GenerationType.SEQUENCE,
			generator = "address_seq_id"
			)
	private Long addressId;
	private String address1;
	private String address2;
	private String street;
	private String city;
	private String state;
	private Integer zipCode;
	private Float latitude;
	private Float longitude;
	
}
