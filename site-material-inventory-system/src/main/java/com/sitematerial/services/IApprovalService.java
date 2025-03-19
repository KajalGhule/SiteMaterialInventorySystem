package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.Approval;

public interface IApprovalService {
    Approval createApproval(Approval approval);
    List<Approval> getAllApprovals();
    Approval getApprovalById(Integer id);
    void deleteApproval(Integer id);
}