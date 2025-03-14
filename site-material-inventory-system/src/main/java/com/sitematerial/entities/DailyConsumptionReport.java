package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DailyConsumptionReports")
public class DailyConsumptionReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportID;

    @ManyToOne
    @JoinColumn(name = "siteID")
    private Site site;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "materialID")
    private Material material;

    private Integer quantityUsed;
    private String usedBy;
    private String workDetail;

    public DailyConsumptionReport() {
		// TODO Auto-generated constructor stub
	}

	public DailyConsumptionReport(Integer reportID, Site site, LocalDate date, Material material, Integer quantityUsed,
			String usedBy, String workDetail) {
		super();
		this.reportID = reportID;
		this.site = site;
		this.date = date;
		this.material = material;
		this.quantityUsed = quantityUsed;
		this.usedBy = usedBy;
		this.workDetail = workDetail;
	}

	public Integer getReportID() {
		return reportID;
	}

	public void setReportID(Integer reportID) {
		this.reportID = reportID;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getQuantityUsed() {
		return quantityUsed;
	}

	public void setQuantityUsed(Integer quantityUsed) {
		this.quantityUsed = quantityUsed;
	}

	public String getUsedBy() {
		return usedBy;
	}

	public void setUsedBy(String usedBy) {
		this.usedBy = usedBy;
	}

	public String getWorkDetail() {
		return workDetail;
	}

	public void setWorkDetail(String workDetail) {
		this.workDetail = workDetail;
	}

	@Override
	public String toString() {
		return "DailyConsumptionReport [reportID=" + reportID + ", site=" + site + ", date=" + date + ", material="
				+ material + ", quantityUsed=" + quantityUsed + ", usedBy=" + usedBy + ", workDetail=" + workDetail
				+ "]";
	}
    
}