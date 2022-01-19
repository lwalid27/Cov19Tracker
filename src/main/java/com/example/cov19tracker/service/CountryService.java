package com.example.cov19tracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cov19tracker.exception.NotFoundException;
import com.example.cov19tracker.model.Country;
import com.example.cov19tracker.repo.CountryRepo;

@Service
@Transactional
public class CountryService {
	
	private final CountryRepo countryRepo;

	@Autowired
	public CountryService(CountryRepo countryRepo) {
		this.countryRepo = countryRepo;
	}

	public Country addCountry(Country country) {
		return countryRepo.save(country);
	}

	public List<Country> findAllCountries() {
		return countryRepo.findAll();
	}

	public Country updateCountry(Country country) {
		return countryRepo.save(country);
	}

	public Country findCountryById(Long id) {
		return countryRepo.findCountryById(id)
				.orElseThrow(() -> new NotFoundException("country by id " + id + " was not found"));
	}

	public void deleteCountry(Long id) {
		countryRepo.deleteCountryById(id);
	}

}
