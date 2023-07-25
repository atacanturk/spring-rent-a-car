package com.javaproject.rentACar.business.abstracts;

import java.util.List;

import com.javaproject.rentACar.business.requests.CreateBrandRequest;
import com.javaproject.rentACar.business.requests.UpdateBrandRequest;
import com.javaproject.rentACar.business.responses.GetAllBrandsResponse;
import com.javaproject.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete (int id);
}
