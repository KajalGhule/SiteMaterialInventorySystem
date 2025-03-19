package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.Supplier;

public interface ISupplierService {
    Supplier createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Integer id);
    Supplier updateSupplier(Integer id, Supplier supplier);
    void deleteSupplier(Integer id);
}