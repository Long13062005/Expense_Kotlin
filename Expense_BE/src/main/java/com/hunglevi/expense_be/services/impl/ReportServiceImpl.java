package com.hunglevi.expense_be.services.impl;

import com.hunglevi.expense_be.model.Category;
import com.hunglevi.expense_be.model.Report;
import com.hunglevi.expense_be.repository.CategoryRepository;
import com.hunglevi.expense_be.repository.ReportRepository;
import com.hunglevi.expense_be.services.ICategoryService;
import com.hunglevi.expense_be.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Override
    public List<Report> getAllReports() {
        return List.of();
    }

    @Override
    public Report getReportById(Integer id) {
        return null;
    }

    @Override
    public Report saveReport(Report report) {
        return null;
    }

    @Override
    public void deleteReport(Integer id) {

    }

    @Override
    public List<Report> getReportsByUserId(Integer userId) {
        return List.of();
    }
}