package com.ctustech.api.consume;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="products")
public class TempProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@JsonProperty("Year")
	private String year;
	@JsonProperty("Week")
    private String week;
    @JsonProperty("Type of alert")
    private String alertType;
    @JsonProperty("Product user")
    private String productUser;
    @JsonProperty("Alert number")
    private String alertNumber;
    @JsonProperty("Alert submitted by")
    private String submittedBy;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Product")
    private String product;
    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type / number of model")
    @Column(columnDefinition="TEXT")
    private String numberOfModel;
    @JsonProperty("Batch number / Barcode")
    private String batchNumberOrBarcode;
    @JsonProperty("OECD Portal Category")
    private String portalCategory;
    @JsonProperty("Description")
    @Column(columnDefinition="TEXT")
    private String description;
    @JsonProperty("Country of origin")
    private String countryOfOrigin;
    @JsonProperty("Counterfeit")
    private String counterfeit;
    @JsonProperty("Risk type")
    private String riskType;
    @JsonProperty("Technical defect")
    @Column(columnDefinition="TEXT")
    private String technicalDefect;
    @JsonProperty("Risk")
    private String risk;
    @JsonProperty("Measures adopted by notifying country")
    private String adoptedMeassure;
    @JsonProperty("Products were found and measures were taken also in")
    private String foundAndTakenMeassure;
    @JsonProperty("Company recall page")
    private String companyRecallPage;
    @JsonProperty("URL of Case")
    @Column(columnDefinition="TEXT")
    private String urlOfCase;
    @JsonProperty("Barcode")
    private String barCode;
    @JsonProperty("Batch number")
    private String batchNumber;
    @JsonAlias({"Company recall code (**)","Company recall code"})
    @JsonProperty("Company recall code (**)")
    private String companyRecallCode;
    @JsonAlias({"Production dates (**)","Production dates"})
    @JsonProperty("Production dates (**)")
    private String productionDates;
    @JsonProperty("Packaging description")
    @Column(columnDefinition="TEXT")
    private String packagingDescription;
}
