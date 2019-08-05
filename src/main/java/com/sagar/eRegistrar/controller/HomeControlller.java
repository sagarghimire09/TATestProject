package com.sagar.eRegistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlller {
	
	@GetMapping(value = {"/eregistrar","/eregistrar/home"})
	public String getHomepage() {
		return "home/index";
	}
	
}
