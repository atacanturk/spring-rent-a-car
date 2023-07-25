package com.javaproject.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

	@Query
	boolean existByName(String name); //spring jpa keywords
}
