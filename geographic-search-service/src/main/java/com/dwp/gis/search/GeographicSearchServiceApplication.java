package com.dwp.gis.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dwp.gis.search.service.GeographicSearchServiceController;

/**
 * 
 * Geographic Search Service SpringBoot Application
 * 
 * @author Roger.Gale
 * @since  20 January 2020
 * 
 **/
@SpringBootApplication
@ComponentScan(basePackageClasses=GeographicSearchServiceController.class)
public class GeographicSearchServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeographicSearchServiceApplication.class, args);
	}
}
