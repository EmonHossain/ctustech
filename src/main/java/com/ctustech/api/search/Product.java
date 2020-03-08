package com.ctustech.api.search;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName="counterfiet", type="product")
public class Product {
	
	@Id
	private String id;
	//@JsonProperty("Year")
	private String year;
	//@JsonProperty("Week")
    private String week;
    //@JsonProperty("Type of alert")
    private String alertType;
    //@JsonProperty("Product user")
    private String productUser;
    //@JsonProperty("Alert number")
    private String alertNumber;
    //@JsonProperty("Alert submitted by")
    private String submittedBy;
    //@JsonProperty("Category")
    private String category;
    //@JsonProperty("Product")
    private String product;
    //@JsonProperty("Brand")
    private String brand;
    //@JsonProperty("Name")
    private String name;
    //@JsonProperty("Type / number of model")
    //@Column(columnDefinition="TEXT")
    private String numberOfModel;
    //@JsonProperty("Batch number / Barcode")
    private String batchNumberOrBarcode;
    //@JsonProperty("OECD Portal Category")
    private String portalCategory;
    //@JsonProperty("Description")
    //@Column(columnDefinition="TEXT")
    private String description;
    //@JsonProperty("Country of origin")
    private String countryOfOrigin;
    //@JsonProperty("Counterfeit")
    private String counterfeit;
    //@JsonProperty("Risk type")
    private String riskType;
    //@JsonProperty("Technical defect")
    //@Column(columnDefinition="TEXT")
    private String technicalDefect;
    //@JsonProperty("Risk")
    private String risk;
    //@JsonProperty("Measures adopted by notifying country")
    private String adoptedMeassure;
    //@JsonProperty("Products were found and measures were taken also in")
    private String foundAndTakenMeassure;
    //@JsonProperty("Company recall page")
    private String companyRecallPage;
    //@JsonProperty("URL of Case")
    private String urlOfCase;
    //@JsonProperty("Barcode")
    private String barCode;
    //@JsonProperty("Batch number")
    private String batchNumber;
    //@JsonAlias({"Company recall code (**)","Company recall code"})
    //@JsonProperty("Company recall code (**)")
    private String companyRecallCode;
    //@JsonAlias({"Production dates (**)","Production dates"})
    //@JsonProperty("Production dates (**)")
    private String productionDates;
    //@JsonProperty("Packaging description")
    private String packagingDescription;	
}
