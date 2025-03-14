package com.sitematerial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MaterialSiteStock")
public class MaterialSiteStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "siteID")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "materialID")
    private Material material;

    private Integer currentStock;

    public MaterialSiteStock() {
		// TODO Auto-generated constructor stub
	}

	public MaterialSiteStock(Integer id, Site site, Material material, Integer currentStock) {
		super();
		this.id = id;
		this.site = site;
		this.material = material;
		this.currentStock = currentStock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	@Override
	public String toString() {
		return "MaterialSiteStock [id=" + id + ", site=" + site + ", material=" + material + ", currentStock="
				+ currentStock + "]";
	}
    
}