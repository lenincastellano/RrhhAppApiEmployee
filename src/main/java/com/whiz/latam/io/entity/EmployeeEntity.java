package com.whiz.latam.io.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "gender_id", nullable = false)
	private int genderId;
	
	@Column(name = "job_id", nullable = false)
	private int jobId;
	
	@Column(name = "name", nullable = false, length = 255)
	private String  name;
	
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;
	
}
