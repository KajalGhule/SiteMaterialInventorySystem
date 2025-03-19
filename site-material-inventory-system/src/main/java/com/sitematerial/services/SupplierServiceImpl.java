package com.sitematerial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.entities.Supplier;
import com.sitematerial.repositories.SupplierRepository;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(Integer id, Supplier updatedSupplier) {
        Supplier existing = getSupplierById(id);
        if (existing != null) {
            existing.setSupplierName(updatedSupplier.getSupplierName());
            existing.setContactPerson(updatedSupplier.getContactPerson());
            existing.setPhoneNumber(updatedSupplier.getPhoneNumber());
            return supplierRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}