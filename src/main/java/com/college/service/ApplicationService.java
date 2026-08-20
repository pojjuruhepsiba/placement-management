package com.college.placement.service;

import com.college.placement.entity.Application;
import com.college.placement.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // Submit application
    public Application apply(Application application) {
        application.setStatus("APPLIED");
        return applicationRepository.save(application);
    }

    // Get all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get application by ID
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    // Update application status
    public Optional<Application> updateStatus(Long id, String status) {

        Optional<Application> existingApplication =
                applicationRepository.findById(id);

        if (existingApplication.isPresent()) {

            Application application = existingApplication.get();
            application.setStatus(status);

            return Optional.of(applicationRepository.save(application));
        }

        return Optional.empty();
    }

    // Delete application
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}