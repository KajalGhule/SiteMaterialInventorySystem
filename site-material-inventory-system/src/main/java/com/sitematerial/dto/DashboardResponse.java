package com.sitematerial.dto;


import java.util.List;

import com.sitematerial.entities.MaterialSiteStock;

public class DashboardResponse {
    private long totalSites;
    private long totalMaterials;
    private long totalUsers;
    private long totalRequests;
    private List<MaterialSiteStock> lowStockMaterials;
	public long getTotalSites() {
		return totalSites;
	}
	public void setTotalSites(long totalSites) {
		this.totalSites = totalSites;
	}
	public long getTotalMaterials() {
		return totalMaterials;
	}
	public void setTotalMaterials(long totalMaterials) {
		this.totalMaterials = totalMaterials;
	}
	public long getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
	public long getTotalRequests() {
		return totalRequests;
	}
	public void setTotalRequests(long totalRequests) {
		this.totalRequests = totalRequests;
	}
	public List<MaterialSiteStock> getLowStockMaterials() {
		return lowStockMaterials;
	}
	public void setLowStockMaterials(List<MaterialSiteStock> lowStockMaterials) {
		this.lowStockMaterials = lowStockMaterials;
	}

    
}
