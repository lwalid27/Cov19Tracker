package com.example.cov19tracker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cov19tracker.model.Country;

public interface CountryRepo extends JpaRepository<Country, Long>{
	
	void deleteCountryById(Long id);

	Optional<Country> findCountryById(Long id);

}
