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
public class Practice {

	@Id
	@SequenceGenerator(
			name = "practice_seq_id",
			sequenceName = "practice_seq_id",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "practice_seq_id"
			)
	private Long practiceId;
	private String name;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "practiceId",
			referencedColumnName = "practiceId"
			)
	private List<Location> location;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "practiceId",
			referencedColumnName = "practiceId"
			)
	private List<PracticeContact> practiceContact;
	
	@OneToMany(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "practiceId",
			referencedColumnName = "practiceId"
			)
	private List<AppointmentType> appointmentType;
}
