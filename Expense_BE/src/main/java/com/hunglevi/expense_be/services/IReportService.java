package com.hunglevi.expense_be.services;

import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.model.Report;

import java.util.List;

public interface IReportService {
    List<Report> getAllReports();
    Report getReportById(Integer id);
    Report saveReport(Report report);
    void deleteReport(Integer id);
    List<Report> getReportsByUserId(Integer userId);
}