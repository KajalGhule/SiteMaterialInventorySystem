package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "LowStockAlerts")
public class LowStockAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertID;

    @ManyToOne
    @JoinColumn(name = "siteID")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "materialID")
    private Material material;

    private LocalDate date;
    private Integer currentStock;
    private Integer reorderLevel;
    private String actionTaken;

    public LowStockAlert() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAlertID() {
		return alertID;
	}

	public void setAlertID(Integer alertID) {
		this.alertID = alertID;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	@Override
	public String toString() {
		return "LowStockAlert [alertID=" + alertID + ", site=" + site + ", material=" + material + ", date=" + date
				+ ", currentStock=" + currentStock + ", reorderLevel=" + reorderLevel + ", actionTaken=" + actionTaken
				+ "]";
	}
    
}