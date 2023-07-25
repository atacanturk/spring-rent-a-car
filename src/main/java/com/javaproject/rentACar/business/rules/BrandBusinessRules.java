package com.javaproject.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.javaproject.rentACar.core.utilities.exceptions.BusinessException;
import com.javaproject.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existByName(name)) {
			throw new BusinessException("Brand name already exists");//Java exception types
		}
	}
}
