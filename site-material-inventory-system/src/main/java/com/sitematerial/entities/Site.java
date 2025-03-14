package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siteID;
    private String siteName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    public Site() {
		// TODO Auto-generated constructor stub
	}
	public Site(Integer siteID, String siteName, String location, LocalDate startDate, LocalDate endDate) {
		super();
		this.siteID = siteID;
		this.siteName = siteName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Integer getSiteID() {
		return siteID;
	}
	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Site [siteID=" + siteID + ", siteName=" + siteName + ", location=" + location + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
    
}