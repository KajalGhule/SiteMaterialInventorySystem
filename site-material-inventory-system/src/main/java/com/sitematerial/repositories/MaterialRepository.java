package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sitematerial.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
	 boolean existsByMaterialName(String materialName);
}