package com.sitematerial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.controllers.MaterialController;
import com.sitematerial.customexceptions.ResourceNotFoundException;
import com.sitematerial.entities.Material;
import com.sitematerial.repositories.MaterialRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MaterialServiceImpl implements IMaterialService {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);
	
    @Autowired
    private MaterialRepository materialRepo;

    @Override
    public Material addMaterial(Material material) {
        if (materialRepo.existsByMaterialName(material.getMaterialName())) {
            throw new RuntimeException("Material already exists.");
        }
        return materialRepo.save(material);
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialRepo.findAll();
    }
    
    @Override
    public Material getMaterialById(Integer id) {
        logger.info("Fetching material with ID: {}", id);
        return materialRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Material not found with ID: " + id));
    }

    @Override
    public Material updateMaterial(Integer id, Material updatedMaterial) {
        Material material = getMaterialById(id);
        material.setMaterialName(updatedMaterial.getMaterialName());
        material.setUnit(updatedMaterial.getUnit());
        material.setReorderLevel(updatedMaterial.getReorderLevel());
        return materialRepo.save(material);
    }

    @Override
    public void deleteMaterial(Integer id) {
        materialRepo.deleteById(id);
    }
}