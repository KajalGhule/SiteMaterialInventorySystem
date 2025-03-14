package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.Material;

public interface IMaterialService {
    Material addMaterial(Material material);
    List<Material> getAllMaterials();
    Material getMaterialById(Integer id);
    Material updateMaterial(Integer id, Material updatedMaterial);
    void deleteMaterial(Integer id);
}