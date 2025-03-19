package com.sitematerial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.customexceptions.ResourceNotFoundException;
import com.sitematerial.entities.Approval;
import com.sitematerial.repositories.ApprovalRepository;

import java.util.List;

@Service
public class ApprovalServiceImpl implements IApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Override
    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    @Override
    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    @Override
    public Approval getApprovalById(Integer id) {
        return approvalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Approval not found"));
    }

    @Override
    public void deleteApproval(Integer id) {
        approvalRepository.deleteById(id);
    }
}