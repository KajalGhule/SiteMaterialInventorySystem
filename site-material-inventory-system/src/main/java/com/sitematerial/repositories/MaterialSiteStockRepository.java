package com.sitematerial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sitematerial.entities.MaterialSiteStock;

public interface MaterialSiteStockRepository extends JpaRepository<MaterialSiteStock, Integer> {

    @Query("SELECT m FROM MaterialSiteStock m WHERE m.currentStock <= m.material.reorderLevel")
    List<MaterialSiteStock> findByCurrentStockLessThanEqualReorderLevel();
    
    List<MaterialSiteStock> findBySite_SiteID(Integer siteId);
}
