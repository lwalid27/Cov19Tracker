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

import com.example.cov19tracker.model.Vaccin;
import com.example.cov19tracker.service.VaccinService;

@RestController
@RequestMapping("/vaccin")
public class VaccinResource {
	
	private final VaccinService vaccinService;

    public VaccinResource(VaccinService vaccinService) {
        this.vaccinService = vaccinService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vaccin>> getAllVaccins () {
        List<Vaccin> vaccins = vaccinService.findAllVaccins();
        return new ResponseEntity<>(vaccins, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vaccin> getVaccinById (@PathVariable("id") Long id) {
    	Vaccin vaccin = vaccinService.findVaccinById(id);
        return new ResponseEntity<>(vaccin, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vaccin> addVaccin(@RequestBody Vaccin vaccin) {
    	Vaccin newVaccin = vaccinService.addVaccin(vaccin);
        return new ResponseEntity<>(newVaccin, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vaccin> updateVaccin(@RequestBody Vaccin vaccin) {
    	Vaccin updateVaccin = vaccinService.updateVaccin(vaccin);
        return new ResponseEntity<>(updateVaccin, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVaccin(@PathVariable("id") Long id) {
    	vaccinService.deleteVaccin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
