package com.seifernet.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

	@RequestMapping( "/index" )
	public String index(  ){
		
		return "index";
	}
	
}
