package com.example.cov19tracker.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cov19tracker.exception.NotFoundException;
import com.example.cov19tracker.model.Test;
import com.example.cov19tracker.repo.TestRepo;

@Service
@Transactional
public class TestService {
	
private final TestRepo testRepo;
	
	@Autowired
    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public Test addTest(Test test) {
    	return testRepo.save(test);
    }

    public List<Test> findAllTests() {
        return testRepo.findAll();
    }

    public Test updateTest(Test test) {
        return testRepo.save(test);
    }

    public Test findTestById(Long id) {
        return testRepo.findTestById(id)
                .orElseThrow(() -> new NotFoundException("test by id " + id + " was not found"));
    }

    public void deleteTest(Long id){
    	testRepo.deleteTestById(id);
    }

}
