package com.seifernet.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seifernet.spring.engine.DataObject;

@RestController
public class ServiceController {

	@RequestMapping( "/api/getObject" )
	public DataObject getObject(  ){
		return new DataObject( );
	}
	
}
