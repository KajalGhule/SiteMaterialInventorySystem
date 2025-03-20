package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.sitematerial.dto.MaterialUsageDTO;
import com.sitematerial.entities.DailyConsumptionReport;

import java.time.LocalDate;
import java.util.List;

public interface DailyConsumptionReportRepository extends JpaRepository<DailyConsumptionReport, Integer> {

    @Query("SELECT new com.sitematerial.dto.MaterialUsageDTO(" +
           "d.material.materialName, d.date, d.quantityUsed, d.usedBy, d.workDetail) " +
           "FROM DailyConsumptionReport d WHERE d.site.siteID = :siteId AND d.date BETWEEN :start AND :end")
    List<MaterialUsageDTO> getUsageBySiteIdBetweenDates(@Param("siteId") Integer siteId,
                                                        @Param("start") LocalDate start,
                                                        @Param("end") LocalDate end);
    
//    List<DailyConsumptionReport> findBySite_SiteIDAndDateBetween(Integer siteID);
    List<DailyConsumptionReport> findByDate(LocalDate date);
}
