package com.sitematerial.services;

import java.time.LocalDate;
import java.util.List;

import com.sitematerial.dto.MaterialUsageDTO;
import com.sitematerial.entities.MaterialSiteStock;

public interface IReportService {
	
	List<MaterialUsageDTO> getMaterialUsage(Integer siteId, LocalDate start, LocalDate end);
	
	List<MaterialSiteStock> getStockSummaryBySite(Integer siteId);
}
