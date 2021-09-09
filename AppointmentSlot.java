package com.utf3164.fahrenheit.entity;

import java.sql.Date;
import java.sql.Time;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentSlot {

	@Id
	@SequenceGenerator(
			name = "appointmentSlot_sequence", 
			sequenceName = "appointmentSlot_sequence", 
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "appointmentSlot_sequence"
			)
	
	private Long appointmentSlotId;
	private Time fromTime;
	private Time endTime;
	private Date slotDate;
	private Long openSlots;
	private Long totalSlot;
	
	@OneToOne
	@JoinColumn(
			name = "providerId",
			referencedColumnName = "providerId"
	)
	
	private Provider provider;

	@OneToOne
	@JoinColumn(
			name = "appointmentTypeId", 
			referencedColumnName = "appointmentTypeId"
			)
	
	private AppointmentType appointmentType;

	@OneToOne
	@JoinColumn(
			name = "locationId", 
			referencedColumnName = "locationId")
	
	private Location location;
	
	@OneToMany( 
			cascade = CascadeType.ALL 
			)
	@JoinColumn(
			name = "appointmentSlotId",
			referencedColumnName = "appointmentSlotId"
			)
	
	private List<Appointment> appointment;
}
