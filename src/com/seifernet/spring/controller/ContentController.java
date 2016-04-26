package com.seifernet.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

	@RequestMapping( "/index" )
	public String index( Model model ){
		
		model.addAttribute( "content" ,  new Date( ) );
		
		return "index";
	}
	
}
