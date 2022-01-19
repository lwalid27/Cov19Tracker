package com.example.cov19tracker.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cov19tracker.exception.NotFoundException;
import com.example.cov19tracker.model.Patient;
import com.example.cov19tracker.repo.PatientRepo;

@Service
@Transactional
public class PatientService {

	private final PatientRepo patientRepo;

	@Autowired
	public PatientService(PatientRepo patientRepo) {
		this.patientRepo = patientRepo;
	}

	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	public List<Patient> findAllPatients() {
		return patientRepo.findAll();
	}

	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	public Patient findPatientById(Long id) {
		return patientRepo.findPatientById(id)
				.orElseThrow(() -> new NotFoundException("patient by id " + id + " was not found"));
	}

	public void deletePatient(Long id) {
		patientRepo.deletePatientById(id);
	}

}
