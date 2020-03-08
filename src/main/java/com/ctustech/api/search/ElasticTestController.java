package com.ctustech.api.search;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class ElasticTestController {
	
	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	
	@Autowired
	private ElasticRepository elasticRepository;
	
	/*
	@GetMapping("/save")
	public String save() {
		FakeSample fs = new FakeSample(2L,"Fighter plane","toy","China");
		IndexQuery index = new IndexQueryBuilder().withId(String.valueOf(fs.getId())).withObject(fs).build();
		String id = elasticsearchOperations.index(index);
		return id;
	}
	
	@GetMapping("/item")
	public FakeSample getItem() {
		FakeSample fakeSample = elasticsearchOperations.queryForObject(GetQuery.getById("1"), FakeSample.class);
		return fakeSample;
	}
	
	@GetMapping("/repoitem")
	public List<Product> getItemFromRepo() {
		List<Product> samples = elasticRepository.findAll();
		return samples;
	}
	
	@GetMapping("/repoitemname")
	public List<Product> getItemFromRepoByName() {
		List<Product> samples = elasticRepository.findByName("fighter");
		return samples;
	}
	
	@GetMapping("/repoitemsearch/{q}")
	public List<FakeSample> getItemSearch(@PathVariable(name="q") String text) {
		QueryBuilder builders = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(text).lenient(true).field("name").field("type").field("origin"))
				.should(QueryBuilders.queryStringQuery("*"+text+"*").lenient(true).field("name").field("type").field("origin"));
		
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(builders).build();
		List<FakeSample> samples = elasticsearchOperations.queryForList(query, FakeSample.class);
		return samples;
	}
	*/
	
	@GetMapping("/search")
	public List<Product> getSearchedItem(@RequestParam(name="q") String text) {
		QueryBuilder builders = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(text).lenient(true).field("name").field("type").field("origin"))
				.should(QueryBuilders.queryStringQuery("*"+text+"*").lenient(true).field("name").field("type").field("origin"));
		
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(builders).build();
		List<Product> samples = elasticsearchOperations.queryForList(query, Product.class);
		return samples;
	}
	
	@GetMapping("/list")
	public List<Product> getItemList() {
		List<Product> products = elasticRepository.findAll();
		return products;
	}
	
	@GetMapping("/item")
	public Product getDetails(@RequestParam(name="q") String id) {
		return elasticsearchOperations.queryForObject(GetQuery.getById(id), Product.class);
	}
}
