package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.MaterialRequest;

public interface IMaterialRequestService {
	MaterialRequest createRequest(MaterialRequest request);
    List<MaterialRequest> getAllRequests();
    MaterialRequest getRequestById(Integer id);
    void deleteRequest(Integer id);
}
