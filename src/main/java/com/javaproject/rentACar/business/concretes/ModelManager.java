package com.javaproject.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaproject.rentACar.business.abstracts.ModelService;
import com.javaproject.rentACar.business.requests.CreateModelRequest;
import com.javaproject.rentACar.business.responses.GetAllModelsResponse;
import com.javaproject.rentACar.core.utilities.mappers.ModelMapperService;
import com.javaproject.rentACar.dataAccess.abstracts.ModelRepository;
import com.javaproject.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {

		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse =models.stream()
				.map(model->this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).toList(); //1:43:55
		
		return modelsResponse;  
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

}
