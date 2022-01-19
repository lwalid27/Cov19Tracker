package com.example.cov19tracker.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cov19tracker.exception.NotFoundException;
import com.example.cov19tracker.model.Vaccin;
import com.example.cov19tracker.repo.VaccinRepo;

@Service
@Transactional
public class VaccinService {

	private final VaccinRepo vaccinRepo;

	@Autowired
	public VaccinService(VaccinRepo vaccinRepo) {
		this.vaccinRepo = vaccinRepo;
	}

	public Vaccin addVaccin(Vaccin vaccin) {
		return vaccinRepo.save(vaccin);
	}

	public List<Vaccin> findAllVaccins() {
		return vaccinRepo.findAll();
	}

	public Vaccin updateVaccin(Vaccin vaccin) {
		return vaccinRepo.save(vaccin);
	}

	public Vaccin findVaccinById(Long id) {
		return vaccinRepo.findVaccinById(id)
				.orElseThrow(() -> new NotFoundException("vaccin by id " + id + " was not found"));
	}

	public void deleteVaccin(Long id) {
		vaccinRepo.deleteVaccinById(id);
	}

}
