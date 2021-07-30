package com.azhagesan.assessment.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.azhagesan.assessment.controller.StockInventoryController;

@Configuration
public class RestConfig extends ResourceConfig {

	public RestConfig() {
	        
	        register(StockInventoryController.class);
	        
	    }

}
