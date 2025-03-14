package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MaterialRequests")
public class MaterialRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestID;

    @ManyToOne
    @JoinColumn(name = "siteId")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "materialId")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "requestedBy")
    private User requestedBy;

    private Integer quantity;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { Pending, Approved, Rejected }

    public MaterialRequest() {
		// TODO Auto-generated constructor stub
	}

	public MaterialRequest(Integer requestID, Site site, Material material, User requestedBy, Integer quantity,
			LocalDate date, Status status) {
		super();
		this.requestID = requestID;
		this.site = site;
		this.material = material;
		this.requestedBy = requestedBy;
		this.quantity = quantity;
		this.date = date;
		this.status = status;
	}

	public Integer getrequestID() {
		return requestID;
	}

	public void setrequestID(Integer requestID) {
		this.requestID = requestID;
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

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MaterialRequest [requestID=" + requestID + ", site=" + site + ", material=" + material
				+ ", requestedBy=" + requestedBy + ", quantity=" + quantity + ", date=" + date + ", status=" + status
				+ "]";
	}
    
}