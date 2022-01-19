package com.example.cov19tracker.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cov19tracker.model.Test;

public interface TestRepo extends JpaRepository<Test, Long> {

	void deleteTestById(Long id);

	Optional<Test> findTestById(Long id);

}
