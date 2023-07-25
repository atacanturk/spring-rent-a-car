package com.javaproject.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
