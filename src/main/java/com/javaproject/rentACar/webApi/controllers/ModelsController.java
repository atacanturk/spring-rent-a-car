package com.javaproject.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.rentACar.business.abstracts.ModelService;
import com.javaproject.rentACar.business.requests.CreateModelRequest;
import com.javaproject.rentACar.business.responses.GetAllModelsResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController //spring annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	
	private ModelService modelService;
	
	@GetMapping()
	List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}

}
