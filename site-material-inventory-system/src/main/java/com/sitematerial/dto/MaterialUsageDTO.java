package com.sitematerial.dto;

import java.time.LocalDate;

public class MaterialUsageDTO {
    private String materialName;
    private LocalDate date;
    private Integer quantityUsed;
    private String usedBy;
    private String workDetail;
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	
	public MaterialUsageDTO() {
		// TODO Auto-generated constructor stub
	}
	public MaterialUsageDTO(String materialName, LocalDate date, Integer quantityUsed, String usedBy,
			String workDetail) {
		super();
		this.materialName = materialName;
		this.date = date;
		this.quantityUsed = quantityUsed;
		this.usedBy = usedBy;
		this.workDetail = workDetail;
	}
	
}
