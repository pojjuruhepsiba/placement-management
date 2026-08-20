package com.college.placement.controller;

import com.college.placement.entity.JobDrive;
import com.college.placement.service.JobDriveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-drives")
public class JobDriveController {

    private final JobDriveService jobDriveService;

    public JobDriveController(JobDriveService jobDriveService) {
        this.jobDriveService = jobDriveService;
    }

    // Add a new job drive
    @PostMapping
    public JobDrive addJobDrive(@RequestBody JobDrive jobDrive) {
        return jobDriveService.addJobDrive(jobDrive);
    }

    // Get all job drives
    @GetMapping
    public List<JobDrive> getAllJobDrives() {
        return jobDriveService.getAllJobDrives();
    }

    // Get job drive by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobDrive> getJobDriveById(@PathVariable Long id) {

        return jobDriveService.getJobDriveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete job drive
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobDrive(@PathVariable Long id) {

        jobDriveService.deleteJobDrive(id);

        return ResponseEntity.ok("Job drive deleted successfully");
    }
}