package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
