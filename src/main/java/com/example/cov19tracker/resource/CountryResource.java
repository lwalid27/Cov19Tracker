package com.example.cov19tracker.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cov19tracker.model.Country;
import com.example.cov19tracker.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryResource {
	
	private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries () {
        List<Country> countries = countryService.findAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Country> getCountryById (@PathVariable("id") Long id) {
    	Country country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
    	Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
    	Country updateCountry = countryService.updateCountry(country);
        return new ResponseEntity<>(updateCountry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id) {
    	countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
