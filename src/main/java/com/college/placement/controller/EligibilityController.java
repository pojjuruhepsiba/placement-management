package com.college.placement.controller;

import com.college.placement.entity.EligibilityCriteria;
import com.college.placement.entity.Student;
import com.college.placement.repository.StudentRepository;
import com.college.placement.service.StudentEligibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    private final StudentRepository studentRepository;
    private final StudentEligibilityService eligibilityService;

    public EligibilityController(
            StudentRepository studentRepository,
            StudentEligibilityService eligibilityService) {

        this.studentRepository = studentRepository;
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<String> checkEligibility(
            @PathVariable Long studentId,
            @RequestBody EligibilityCriteria criteria) {

        return studentRepository.findById(studentId)
                .map(student -> {

                    boolean eligible =
                            eligibilityService.isEligible(student, criteria);

                    if (eligible) {
                        return ResponseEntity.ok(
                                student.getName() + " is ELIGIBLE"
                        );
                    } else {
                        return ResponseEntity.ok(
                                student.getName() + " is NOT ELIGIBLE"
                        );
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}