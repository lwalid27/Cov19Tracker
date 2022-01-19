package com.example.cov19tracker.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cov19tracker.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	void deletePatientById(Long id);

	Optional<Patient> findPatientById(Long id);

}
