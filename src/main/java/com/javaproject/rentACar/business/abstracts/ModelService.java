package com.javaproject.rentACar.business.abstracts;

import java.util.List;

import com.javaproject.rentACar.business.requests.CreateModelRequest;
import com.javaproject.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {

	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
