package com.sitematerial.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.dto.DashboardResponse;
import com.sitematerial.entities.MaterialSiteStock;
import com.sitematerial.repositories.MaterialRepository;
import com.sitematerial.repositories.MaterialRequestRepository;
import com.sitematerial.repositories.MaterialSiteStockRepository;
import com.sitematerial.repositories.SiteRepository;
import com.sitematerial.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired private SiteRepository siteRepo;
    @Autowired private MaterialRepository materialRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private MaterialRequestRepository requestRepo;
    @Autowired private MaterialSiteStockRepository stockRepo;

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboardData() {
        DashboardResponse response = new DashboardResponse();
        response.setTotalSites(siteRepo.count());
        response.setTotalMaterials(materialRepo.count());
        response.setTotalUsers(userRepo.count());
        response.setTotalRequests(requestRepo.count());

        List<MaterialSiteStock> lowStockList = stockRepo.findByCurrentStockLessThanEqualReorderLevel();
        response.setLowStockMaterials(lowStockList);

        return ResponseEntity.ok(response);
    }
}
