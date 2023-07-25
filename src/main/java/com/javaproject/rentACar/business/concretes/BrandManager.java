package com.javaproject.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaproject.rentACar.business.abstracts.BrandService;
import com.javaproject.rentACar.business.requests.CreateBrandRequest;
import com.javaproject.rentACar.business.requests.UpdateBrandRequest;
import com.javaproject.rentACar.business.responses.GetAllBrandsResponse;
import com.javaproject.rentACar.business.responses.GetByIdBrandResponse;
import com.javaproject.rentACar.business.rules.BrandBusinessRules;
import com.javaproject.rentACar.core.utilities.mappers.ModelMapperService;
import com.javaproject.rentACar.dataAccess.abstracts.BrandRepository;
import com.javaproject.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;


	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse =brands.stream()
				.map(brand->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).toList(); //1:43:55
		
		return brandsResponse;  
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName()); //iş kuralı
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {

		this.brandRepository.deleteById(id);
		
	}

}
