package com.hgp.contoladorveiculos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hgp.contoladorveiculos.dtos.VehicleInsertDTO;
import com.hgp.contoladorveiculos.entities.Brand;
import com.hgp.contoladorveiculos.entities.Model;
import com.hgp.contoladorveiculos.entities.ModelGetter;

@Service
public class FipeService {

	private final String principalPath = "https://parallelum.com.br/fipe/api/v1/";
	private String path;
	private List<Brand> brands = new ArrayList<>();
	private List<Model> models = new ArrayList<>();

	@Autowired
	private RestTemplate restTemplate;

	public VehicleInsertDTO getVehicle(VehicleInsertDTO dto) {
		getVehicleCompletePath(dto);
		VehicleInsertDTO vehicle = restTemplate.getForObject(path, VehicleInsertDTO.class);
		vehicle.setType(dto.getType());
		vehicle.setUserName(dto.getUserName());
		return vehicle;
	}
	
	private void getVehicleCompletePath(VehicleInsertDTO dto) {
		getBrands(dto.getType());
		Long brandId = getBrandId(dto.getBrand());
		
		getModels(brandId);
		String modelId = getModelId(dto.getModel());
		
		path += "/" + modelId + "/anos/" + dto.getYear(); 
	}
	
	private void getBrands(String type){
		path = principalPath + type + "/marcas";
		brands = restTemplate
				.exchange(path,HttpMethod.GET, null, new ParameterizedTypeReference<List<Brand>>() {})
				.getBody();
	}
	
	private Long getBrandId(String brandName) {
		for(Brand brand : brands) {
			if(brand.getName().equals(brandName)) return brand.getId();
		}
		return null;
	}
	
	private void getModels(Long brandId) {
		path += "/" + brandId + "/modelos";
		ModelGetter modelGetter = restTemplate.getForObject(path, ModelGetter.class);
		models = modelGetter.getModelos();
	}
	
	private String getModelId(String modelName) {
		for(Model model : models) {
			if(model.getName().equals(modelName)) return model.getId();
		}
		return null;
	}
}
