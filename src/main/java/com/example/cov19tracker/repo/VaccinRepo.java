package com.example.cov19tracker.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cov19tracker.model.Vaccin;

public interface VaccinRepo extends JpaRepository<Vaccin, Long> {

	void deleteVaccinById(Long id);

	Optional<Vaccin> findVaccinById(Long id);

}
