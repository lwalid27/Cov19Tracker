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

import com.example.cov19tracker.model.Test;
import com.example.cov19tracker.service.TestService;

@RestController
@RequestMapping("/test")
public class TestResource {
	
	private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Test>> getAllTests () {
        List<Test> tests = testService.findAllTests();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Test> getTestById (@PathVariable("id") Long id) {
    	Test test = testService.findTestById(id);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Test> addTest(@RequestBody Test test) {
    	Test newTest = testService.addTest(test);
        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Test> updateTest(@RequestBody Test test) {
    	Test updateTest = testService.updateTest(test);
        return new ResponseEntity<>(updateTest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable("id") Long id) {
    	testService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
