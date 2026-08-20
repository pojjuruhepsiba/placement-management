package com.college.placement.service;

import com.college.placement.entity.JobDrive;
import com.college.placement.repository.JobDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobDriveService {

    private final JobDriveRepository jobDriveRepository;

    public JobDriveService(JobDriveRepository jobDriveRepository) {
        this.jobDriveRepository = jobDriveRepository;
    }

    // Add a new job drive
    public JobDrive addJobDrive(JobDrive jobDrive) {
        return jobDriveRepository.save(jobDrive);
    }

    // Get all job drives
    public List<JobDrive> getAllJobDrives() {
        return jobDriveRepository.findAll();
    }

    // Get job drive by ID
    public Optional<JobDrive> getJobDriveById(Long id) {
        return jobDriveRepository.findById(id);
    }

    // Delete job drive
    public void deleteJobDrive(Long id) {
        jobDriveRepository.deleteById(id);
    }
}