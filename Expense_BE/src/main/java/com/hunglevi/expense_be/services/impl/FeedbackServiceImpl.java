package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.Feedback;
import com.hunglevi.expense_be.repository.FeedbackRepository;
import com.hunglevi.expense_be.services.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    @Override
    public Optional<Feedback> getFeedbackById(Integer id) {
        return feedbackRepository.findById(Long.valueOf(id));
    }


    @Override
    public void deleteFeedback(Integer id) {

    }

    @Override
    public List<Feedback> searchFeedbacksByContent(String searchTerm) {
        return List.of();
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}