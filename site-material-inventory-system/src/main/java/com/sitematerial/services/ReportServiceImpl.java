package com.sitematerial.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.dto.MaterialUsageDTO;
import com.sitematerial.entities.MaterialSiteStock;
import com.sitematerial.repositories.DailyConsumptionReportRepository;
import com.sitematerial.repositories.MaterialSiteStockRepository;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private DailyConsumptionReportRepository reportRepo;
    
    @Autowired
    private MaterialSiteStockRepository stockRepo;

    @Override
    public List<MaterialUsageDTO> getMaterialUsage(Integer siteId, LocalDate start, LocalDate end) {
        return reportRepo.getUsageBySiteIdBetweenDates(siteId, start, end);
    }
    
    @Override
    public List<MaterialSiteStock> getStockSummaryBySite(Integer siteId) {
        return stockRepo.findBySite_SiteID(siteId);
    }
}
