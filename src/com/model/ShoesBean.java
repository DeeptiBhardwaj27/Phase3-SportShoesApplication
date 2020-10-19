package com.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class ShoesBean {
	
	@NotEmpty
	private String sportShoesBrand;
	
	@NotEmpty
	private String accessories;
	
	@NotNull(message = "Provide the quantity")
	@Range(max = 10, min = 1, message = "must be between 1 and 10")
	private Integer noOfShoes;

	public String getSportShoesBrand() {
		return sportShoesBrand;
	}

	public void setSportShoesBrand(String sportShoesBrand) {
		this.sportShoesBrand = sportShoesBrand;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public Integer getNoOfShoes() {
		return noOfShoes;
	}

	public void setNoOfShoes(Integer noOfShoes) {
		this.noOfShoes = noOfShoes;
	}
	
	


}



