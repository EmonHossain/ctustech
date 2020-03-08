package com.ctustech.api.consume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ctustech.api.search.ElasticRepository;
import com.ctustech.api.search.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileConsumer {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ElasticRepository elasticRepository;

	public List<TempProduct> consumeJsonFile() {
		List<TempProduct> products = null;
		try {
			File file = ResourceUtils.getFile("classpath:csvjson.json");
			// String content = FileUtils.readFileToString(new
			// File("classpath:/static/csvjson.json"), "UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			products = mapper.readValue(file, new TypeReference<List<TempProduct>>() {
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public void saveDataToDB(List<TempProduct> products) {
		if (products != null) {
			productRepository.saveAll(products);
			// elasticRepository.saveAll(products);
		}
	}

	public void saveDataToElasticServer(List<Product> products) {
		
		if (products != null) {
			elasticRepository.saveAll(products);
		}
	}

	public List<Product> mapProduct() {
		List<Product> products = new ArrayList<Product>();
		List<TempProduct> temp = productRepository.findAll();
		for (TempProduct t : temp) {
			Product p = new Product();
			p.setId(String.valueOf(t.getId()));
			p.setAdoptedMeassure(t.getAdoptedMeassure());
			p.setAlertNumber(t.getAlertNumber());
			p.setAlertType(t.getAlertType());
			p.setBarCode(t.getBarCode());
			p.setBatchNumber(t.getBatchNumber());
			p.setBatchNumberOrBarcode(t.getBatchNumberOrBarcode());
			p.setBrand(t.getBrand());
			p.setCategory(t.getCategory());
			p.setCompanyRecallCode(t.getCompanyRecallCode());
			p.setCompanyRecallPage(t.getCompanyRecallPage());
			p.setCounterfeit(t.getCounterfeit());
			p.setCountryOfOrigin(t.getCountryOfOrigin());
			p.setDescription(t.getDescription());
			p.setFoundAndTakenMeassure(t.getFoundAndTakenMeassure());
			p.setName(t.getName());
			p.setNumberOfModel(t.getNumberOfModel());
			p.setPackagingDescription(t.getPackagingDescription());
			p.setPortalCategory(t.getPortalCategory());
			p.setProduct(t.getProduct());
			p.setProductionDates(t.getProductionDates());
			p.setRisk(t.getRisk());
			p.setRiskType(t.getRiskType());
			p.setSubmittedBy(t.getSubmittedBy());
			p.setTechnicalDefect(t.getTechnicalDefect());
			p.setUrlOfCase(t.getUrlOfCase());
			p.setWeek(t.getWeek());
			p.setYear(t.getYear());
			
			products.add(p);
			
		}
		return products;
	}
}
