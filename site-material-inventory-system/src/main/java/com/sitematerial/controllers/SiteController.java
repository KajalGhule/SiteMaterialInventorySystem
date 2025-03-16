package com.sitematerial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sitematerial.entities.Site;
import com.sitematerial.services.SiteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/sites")
public class SiteController {

    private static final Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private SiteServiceImpl siteService;

    @GetMapping("/all")
    public ResponseEntity<List<Site>> getAllSites() {
        logger.info("GET /api/sites called");
        return ResponseEntity.ok(siteService.getAllSites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable Integer id) {
        logger.info("GET /api/sites/{} called", id);
        Site site = siteService.getSiteById(id);
        return (site != null) ? ResponseEntity.ok(site) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Site> createSite(@RequestBody Site site) {
        logger.info("POST /api/sites called");
        return ResponseEntity.ok(siteService.createSite(site));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable Integer id, @RequestBody Site site) {
        logger.info("PUT /api/sites/{} called", id);
        Site updated = siteService.updateSite(id, site);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Integer id) {
        logger.info("DELETE /api/sites/{} called", id);
        siteService.deleteSite(id);
        return ResponseEntity.noContent().build();
    }
}
