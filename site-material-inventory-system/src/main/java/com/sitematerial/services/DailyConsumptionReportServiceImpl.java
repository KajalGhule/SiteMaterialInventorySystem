package com.sitematerial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.entities.DailyConsumptionReport;
import com.sitematerial.repositories.DailyConsumptionReportRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyConsumptionReportServiceImpl implements IDailyConsumptionReportService {

    @Autowired
    private DailyConsumptionReportRepository reportRepo;

    @Override
    public DailyConsumptionReport save(DailyConsumptionReport report) {
        return reportRepo.save(report);
    }
    
    @Override
    public List<DailyConsumptionReport> getReportsByDate(LocalDate date) {
        return reportRepo.findByDate(date);
    }

}