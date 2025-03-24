package com.sitematerial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sitematerial.dto.MaterialUsageDTO;
import com.sitematerial.entities.MaterialSiteStock;
import com.sitematerial.repositories.MaterialSiteStockRepository;
import com.sitematerial.services.IReportService;
import com.sitematerial.services.ReportServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private MaterialSiteStockRepository materialSiteStockRepository;
    
    @Autowired
//    private ReportServiceImpl reportService;
    private IReportService reportService;

    @GetMapping("/low-stock")
    public ResponseEntity<List<MaterialSiteStock>> getLowStockMaterials() {
        List<MaterialSiteStock> lowStockList = materialSiteStockRepository.findByCurrentStockLessThanEqualReorderLevel();
        return ResponseEntity.ok(lowStockList);
    }
    
    @GetMapping("/usage/{siteId}")
    public ResponseEntity<List<MaterialUsageDTO>> getMaterialUsageBySite(
            @PathVariable Integer siteId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        LocalDate start = (from != null) ? LocalDate.parse(from) : LocalDate.now().minusDays(7);
        LocalDate end = (to != null) ? LocalDate.parse(to) : LocalDate.now();

        List<MaterialUsageDTO> usageList = reportService.getMaterialUsage(siteId, start, end);
        return ResponseEntity.ok(usageList);
    }
    
    @GetMapping("/stock-summary/{siteId}")
    public ResponseEntity<List<MaterialSiteStock>> getStockSummary(@PathVariable Integer siteId) {
        List<MaterialSiteStock> summary = reportService.getStockSummaryBySite(siteId);
        return ResponseEntity.ok(summary);
    }
}