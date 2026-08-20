package com.college.placement.service;

import com.college.placement.entity.EligibilityCriteria;
import com.college.placement.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentEligibilityService {

    public boolean isEligible(Student student, EligibilityCriteria criteria) {

        // Check CGPA
        if (student.getCgpa() < criteria.getMinimumCgpa()) {
            return false;
        }

        // Check backlogs
        if (student.getBacklogs() > criteria.getMaximumBacklogs()) {
            return false;
        }

        // Check branch
        if (!student.getBranch().equalsIgnoreCase(criteria.getAllowedBranch())) {
            return false;
        }

        return true;
    }
}