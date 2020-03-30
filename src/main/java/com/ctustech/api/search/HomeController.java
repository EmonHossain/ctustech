package com.ctustech.api.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "search";
	}
	
	@GetMapping("/{id}/details")
	public String details() {
		return "details";
	}
	
	
}
