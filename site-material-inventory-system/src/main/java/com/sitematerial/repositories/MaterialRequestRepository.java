package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.MaterialRequest;

public interface MaterialRequestRepository extends JpaRepository<MaterialRequest, Integer> {
}
