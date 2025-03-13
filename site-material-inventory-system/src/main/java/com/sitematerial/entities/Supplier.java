package com.sitematerial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierID;
    private String supplierName;
    private String contactPerson;
    private String phoneNumber;
    
    public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Supplier(Integer supplierID, String supplierName, String contactPerson, String phoneNumber) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.contactPerson = contactPerson;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", contactPerson="
				+ contactPerson + ", phoneNumber=" + phoneNumber + "]";
	}
    
}