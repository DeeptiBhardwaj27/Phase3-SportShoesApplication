package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.model.ShoesBean;

@Service
public class ShoesService {
	private Map<String, Double> shoesBrand = new HashMap<String, Double>();
	private Map<String, Double> accessories = new HashMap<String, Double>();
	
	public Map<String, Double> getShoesDetails(){
		shoesBrand.put("Nike", 1000.0);
		shoesBrand.put("Adidas", 1500.0);
		shoesBrand.put("Action", 800.0);
		shoesBrand.put("Puma", 2000.0);
		
		return shoesBrand;
	}
	
	public Map<String, Double> getAccessoriesDetails(){
		
		accessories.put("N/A", 0.0);
		accessories.put("Extra Comfort Sole", 500.0);
		accessories.put("With Socks", 200.0);
		accessories.put("Extra Laces", 50.0);
		
		return accessories;
		
	}
	
	public double calculateTotal(ShoesBean bean) {
		
		
		//return bean.getNoOfShoes()*(shoesBrand.get(bean.getSportShoesBrand())+accessories.get(bean.getAccessories()));
		
		double d;
		if(bean.getAccessories()=="N/A")
		{
			 d=bean.getNoOfShoes()*(shoesBrand.get(bean.getSportShoesBrand()));
		}
		else
		{
			 d=bean.getNoOfShoes()*(shoesBrand.get(bean.getSportShoesBrand())+accessories.get(bean.getAccessories()));
		}
		return d;
		
	}
	
}



