package com.sitematerial.services;

import com.sitematerial.entities.Site;
import com.sitematerial.repositories.SiteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements ISiteService {

    private static final Logger logger = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public List<Site> getAllSites() {
        logger.info("Fetching all sites");
        return siteRepository.findAll();
    }

    @Override
    public Site getSiteById(Integer id) {
        logger.info("Fetching site by ID: {}", id);
        return siteRepository.findById(id).orElse(null);
    }

    @Override
    public Site createSite(Site site) {
        logger.info("Creating new site: {}", site.getSiteName());
        return siteRepository.save(site);
    }

    @Override
    public Site updateSite(Integer id, Site site) {
        logger.info("Updating site ID: {}", id);
        Site existingSite = siteRepository.findById(id).orElse(null);
        if (existingSite != null) {
            existingSite.setSiteName(site.getSiteName());
            existingSite.setLocation(site.getLocation());
            existingSite.setStartDate(site.getStartDate());
            existingSite.setEndDate(site.getEndDate());
            return siteRepository.save(existingSite);
        }
        return null;
    }

    @Override
    public void deleteSite(Integer id) {
        logger.info("Deleting site ID: {}", id);
        siteRepository.deleteById(id);
    }
}