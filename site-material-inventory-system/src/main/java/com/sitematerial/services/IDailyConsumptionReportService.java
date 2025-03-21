package com.sitematerial.services;

import java.time.LocalDate;
import java.util.List;

import com.sitematerial.entities.DailyConsumptionReport;

public interface IDailyConsumptionReportService {
    DailyConsumptionReport save(DailyConsumptionReport report);
//    List<DailyConsumptionReport> getUsageReport(Integer siteId);
    List<DailyConsumptionReport> getReportsByDate(LocalDate date);
}