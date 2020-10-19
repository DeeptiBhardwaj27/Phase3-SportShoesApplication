package com.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ShoesBean;
import com.service.ShoesService;

@Controller
class ShoesController {
	
	@Autowired
	private ShoesService service;
	
	@RequestMapping(value = "showPage", method = RequestMethod.GET)
	public ModelAndView showPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderpage");
		modelAndView.addObject("bObj", new ShoesBean());
		
		return modelAndView;
		
	}

	@RequestMapping(value = "orderShoes.html", method = RequestMethod.POST)
	public ModelAndView orderShoes(@Valid @ModelAttribute("bObj") ShoesBean shoes, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();

		String pgname="";
		
		if(result.hasErrors()) {
			pgname ="orderpage";
		}
		else {
			double cost = service.calculateTotal(shoes);
			pgname="successOrder";
			modelAndView.addObject("msg", "Thank You for choosing our service. You need to pay Rs."+cost+" on delivery.");
		}
		modelAndView.setViewName(pgname);
		return modelAndView;
	 }
	 
	@ModelAttribute("shoesList")
	public Set<String> getShoes(){
		return service.getShoesDetails().keySet();
	}
	
	@ModelAttribute("accessoriesList")
	public Set<String> getToppings(){
		return service.getAccessoriesDetails().keySet();
	}
}
