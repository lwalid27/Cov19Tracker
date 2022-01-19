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
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
	private Long id;
	
	private LocalDate dot;
	
	//positive=1      negative=0
	private char result;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "patient")
	private Patient patient;

	public Test(Long id, LocalDate dot, char result) {
		super();
		this.id = id;
		this.dot = dot;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDot() {
		return dot;
	}

	public void setDot(LocalDate dot) {
		this.dot = dot;
	}

	public char getResult() {
		return result;
	}

	public void setResult(char result) {
		this.result = result;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	

}
