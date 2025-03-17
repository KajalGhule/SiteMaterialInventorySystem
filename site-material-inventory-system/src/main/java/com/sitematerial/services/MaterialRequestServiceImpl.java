package com.sitematerial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.entities.MaterialRequest;
import com.sitematerial.repositories.MaterialRequestRepository;

import java.util.List;

@Service
public class MaterialRequestServiceImpl implements IMaterialRequestService {

    @Autowired
    private MaterialRequestRepository requestRepository;

    @Override
    public MaterialRequest createRequest(MaterialRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public List<MaterialRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public MaterialRequest getRequestById(Integer id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));
    }

    @Override
    public void deleteRequest(Integer id) {
        requestRepository.deleteById(id);
    }
}

