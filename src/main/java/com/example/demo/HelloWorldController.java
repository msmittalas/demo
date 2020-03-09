package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class HelloWorldController {

	Logger logger= LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping(path = "/")
	public String getWorld()
	{
		logger.info("Salman info");
		logger.trace("Salman trace");
		logger.debug("Salman debug");
		logger.error("Salman error");
		logger.warn("Salman warn");
		
		return "Hello World Salman Khan";
	}
}
