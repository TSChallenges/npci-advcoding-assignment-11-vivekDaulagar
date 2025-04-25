package com.agrichallenge.agdata.model;

public class AgData {
	
    private Integer id;
    private String crop;
    private String region;
    private Integer yield;
    private Integer year;
    // TODO: Default constructor - No arguments
    
	public AgData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    // TODO: Parameterized constructor
	
	public AgData(Integer id, String crop, String region, Integer yield, Integer year) {
		super();
		this.id = id;
		this.crop = crop;
		this.region = region;
		this.yield = yield;
		this.year = year;
	}

	 // TODO: Getters and Setters

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCrop() {
		return crop;
	}


	public void setCrop(String crop) {
		this.crop = crop;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public Integer getYield() {
		return yield;
	}


	public void setYield(Integer yield) {
		this.yield = yield;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


   

}
