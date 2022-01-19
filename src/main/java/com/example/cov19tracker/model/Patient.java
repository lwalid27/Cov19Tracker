package com.example.cov19tracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
	private Long id;

	private String name;
	private LocalDate dob;
	private String address;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "country_name")
	private Country country;

	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Test> covidTests = new ArrayList<Test>();
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vaccin> vaccin = new ArrayList<Vaccin>();
	
	public Patient() {}
	
	public Patient(Long id, String name, LocalDate dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Test> getCovidTests() {
		return covidTests;
	}

	public void setCovidTests(List<Test> covidTests) {
		this.covidTests = covidTests;
	}

	public List<Vaccin> getVaccin() {
		return vaccin;
	}

	public void setVaccin(List<Vaccin> vaccin) {
		this.vaccin = vaccin;
	}

}
