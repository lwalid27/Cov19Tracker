package com.example.cov19tracker.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vaccin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
	private Long id;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "patient")
	private Patient patient;
	
	public Vaccin() {}

	public Vaccin(Long id, LocalDate date) {
		super();
		this.id = id;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


}
