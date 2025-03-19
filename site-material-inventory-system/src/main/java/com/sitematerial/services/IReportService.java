package com.sitematerial.services;

import java.time.LocalDate;
import java.util.List;

import com.sitematerial.dto.MaterialUsageDTO;

public interface IReportService {
	
	List<MaterialUsageDTO> getMaterialUsage(Integer siteId, LocalDate start, LocalDate end);
}
