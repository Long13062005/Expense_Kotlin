package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.Feedback;

import java.util.List;
import java.util.Optional;

public interface IFeedbackService {
    List<Feedback> getAllFeedbacks();
    Optional<Feedback> getFeedbackById(Integer id);
    Feedback saveFeedback(Feedback feedback);
    void deleteFeedback(Integer id);
    List<Feedback> searchFeedbacksByContent(String searchTerm);
}