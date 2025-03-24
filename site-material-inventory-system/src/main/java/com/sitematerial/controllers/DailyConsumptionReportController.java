package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.DailyConsumptionReport;
import com.sitematerial.services.IDailyConsumptionReportService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports/daily")
@CrossOrigin("*")
public class DailyConsumptionReportController {

    private static final Logger logger = LoggerFactory.getLogger(DailyConsumptionReportController.class);

    @Autowired
    private IDailyConsumptionReportService reportService;

    @PostMapping("/usage")
    public ResponseEntity<DailyConsumptionReport> addDailyUsage(@RequestBody DailyConsumptionReport report) {
        logger.info("Adding daily usage for site: {}", report.getSite().getSiteID());
        return ResponseEntity.ok(reportService.save(report));
    }
    
    @GetMapping
    public ResponseEntity<List<DailyConsumptionReport>> getReportsByDate(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<DailyConsumptionReport> reports = reportService.getReportsByDate(localDate);
        return ResponseEntity.ok(reports);
    }

}
