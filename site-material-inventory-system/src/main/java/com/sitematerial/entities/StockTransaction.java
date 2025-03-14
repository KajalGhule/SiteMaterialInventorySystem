package com.sitematerial.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "StockTransactions")
public class StockTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionID;

    @ManyToOne
    @JoinColumn(name = "siteID")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "materialID")
    private Material material;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    private Supplier supplier;

    private String remarks;

    public enum TransactionType { IN, OUT }

    public StockTransaction() {
		// TODO Auto-generated constructor stub
	}

	public StockTransaction(Integer transactionID, Site site, Material material, LocalDate date, TransactionType type,
			Integer quantity, Supplier supplier, String remarks) {
		super();
		this.transactionID = transactionID;
		this.site = site;
		this.material = material;
		this.date = date;
		this.type = type;
		this.quantity = quantity;
		this.supplier = supplier;
		this.remarks = remarks;
	}

	public Integer getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
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

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StockTransaction [transactionID=" + transactionID + ", site=" + site + ", material=" + material
				+ ", date=" + date + ", type=" + type + ", quantity=" + quantity + ", supplier=" + supplier
				+ ", remarks=" + remarks + "]";
	}
    
}
