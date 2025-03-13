package com.sitematerial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialID;

    private String materialName;
    private String unit;
    private Integer reorderLevel;
    
	public Material(Integer materialID, String materialName, String unit, Integer reorderLevel) {
		super();
		this.materialID = materialID;
		this.materialName = materialName;
		this.unit = unit;
		this.reorderLevel = reorderLevel;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getMaterialID() {
		return materialID;
	}
	public void setMaterialID(Integer materialID) {
		this.materialID = materialID;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	@Override
	public String toString() {
		return "Material [materialID=" + materialID + ", materialName=" + materialName + ", unit=" + unit
				+ ", reorderLevel=" + reorderLevel + "]";
	} 
}