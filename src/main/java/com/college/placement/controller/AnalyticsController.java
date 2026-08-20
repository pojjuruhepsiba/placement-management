package com.college.placement.controller;

import com.college.placement.repository.ApplicationRepository;
import com.college.placement.repository.CompanyRepository;
import com.college.placement.repository.JobDriveRepository;
import com.college.placement.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final JobDriveRepository jobDriveRepository;
    private final ApplicationRepository applicationRepository;

    public AnalyticsController(
            StudentRepository studentRepository,
            CompanyRepository companyRepository,
            JobDriveRepository jobDriveRepository,
            ApplicationRepository applicationRepository) {

        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
        this.jobDriveRepository = jobDriveRepository;
        this.applicationRepository = applicationRepository;
    }

    @GetMapping
    public Map<String, Object> getAnalytics() {

        Map<String, Object> analytics = new HashMap<>();

        long totalStudents = studentRepository.count();
        long totalCompanies = companyRepository.count();
        long totalJobDrives = jobDriveRepository.count();
        long totalApplications = applicationRepository.count();

        long selectedStudents = applicationRepository.findAll()
                .stream()
                .filter(application ->
                        "SELECTED".equalsIgnoreCase(application.getStatus()))
                .count();

        long offeredStudents = applicationRepository.findAll()
                .stream()
                .filter(application ->
                        "OFFERED".equalsIgnoreCase(application.getStatus()))
                .count();

        analytics.put("totalStudents", totalStudents);
        analytics.put("totalCompanies", totalCompanies);
        analytics.put("totalJobDrives", totalJobDrives);
        analytics.put("totalApplications", totalApplications);
        analytics.put("selectedStudents", selectedStudents);
        analytics.put("offeredStudents", offeredStudents);

        return analytics;
    }
}