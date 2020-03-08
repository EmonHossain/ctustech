package com.ctustech.api.consume;

import java.io.File;
import java.io.IOException;
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

	public void saveDataToElasticServer() {
		List<Product> products = mapProduct();
		if (products != null) {
			elasticRepository.saveAll(products);
		}
	}

	private List<Product> mapProduct() {
		List<Product> products = null;
		try {
			File file = ResourceUtils.getFile("classpath:csvjson.json");
			ObjectMapper mapper = new ObjectMapper();
			products = mapper.readValue(file, new TypeReference<List<Product>>() {
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
