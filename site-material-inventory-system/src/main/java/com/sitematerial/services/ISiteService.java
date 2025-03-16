package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.Site;

public interface ISiteService {
	List<Site> getAllSites();
    Site getSiteById(Integer id);
    Site createSite(Site site);
    Site updateSite(Integer id, Site site);
    void deleteSite(Integer id);
}
