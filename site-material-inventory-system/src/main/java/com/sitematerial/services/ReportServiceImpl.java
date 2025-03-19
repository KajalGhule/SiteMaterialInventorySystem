package com.sitematerial.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.dto.MaterialUsageDTO;
import com.sitematerial.repositories.DailyConsumptionReportRepository;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private DailyConsumptionReportRepository reportRepo;

    @Override
    public List<MaterialUsageDTO> getMaterialUsage(Integer siteId, LocalDate start, LocalDate end) {
        return reportRepo.getUsageBySiteIdBetweenDates(siteId, start, end);
    }
}
