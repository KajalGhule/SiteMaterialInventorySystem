package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Integer> {
}
