package com.college.placement.service;

import com.college.placement.entity.Interview;
import com.college.placement.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    // Schedule interview
    public Interview scheduleInterview(Interview interview) {
        interview.setStatus("SCHEDULED");
        return interviewRepository.save(interview);
    }

    // Get all interviews
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    // Get interview by ID
    public Optional<Interview> getInterviewById(Long id) {
        return interviewRepository.findById(id);
    }

    // Update interview status
    public Optional<Interview> updateStatus(Long id, String status) {

        Optional<Interview> existingInterview =
                interviewRepository.findById(id);

        if (existingInterview.isPresent()) {

            Interview interview = existingInterview.get();
            interview.setStatus(status);

            return Optional.of(interviewRepository.save(interview));
        }

        return Optional.empty();
    }

    // Delete interview
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}