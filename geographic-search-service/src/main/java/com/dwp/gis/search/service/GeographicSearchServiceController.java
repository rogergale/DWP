package com.dwp.gis.search.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dwp.gis.search.service.compute.IGeographicSearchServiceProcessor;
import com.dwp.gis.search.service.model.Users;
import com.dwp.gis.search.service.exceptions.TechnicalFailureException;
import com.dwp.gis.search.service.utils.ExceptionMessages;

/**
 * 
 * Geographic Search Service Controller handles getUser requests
 * 
 * @param city
 * @param radius
 * @return Users
 * 
 * @author Roger.Gale
 * 
 **/
@RestController
public class GeographicSearchServiceController implements GeographicSearchService {
	static Logger log = Logger.getLogger(GeographicSearchServiceController.class.getName());
	static final String START_MESSAGE = "Starting GeographicSearchServiceController.getUsers()";
	static final String EXIT_MESSAGE = "Exiting GeographicSearchServiceController.getUsers()";
	
	@Autowired
	IGeographicSearchServiceProcessor geographicSearchServiceProcessor;
	
	@Autowired
	public GeographicSearchServiceController(final IGeographicSearchServiceProcessor geographicSearchServiceProcessor) {
		this.geographicSearchServiceProcessor = geographicSearchServiceProcessor;
	}

	@RequestMapping(value = "/geographicsearch/users/{city}/{radius}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Users> getUsers(@PathVariable("city") String city, @PathVariable("radius") String radius) {
		log.info(START_MESSAGE);
		Users users = null;
		try {	
			users = geographicSearchServiceProcessor.getUsers(city, radius);
			return new ResponseEntity<Users>(users, HttpStatus.OK);
		} catch (TechnicalFailureException tfe) {
			log.info(ExceptionMessages.TECHNICAL_FAILURE_EXCEPTION_WARNING + ", " + tfe.getMessage());
			users = new Users(city, radius, tfe.getMessage());
			return new ResponseEntity<Users>(users, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			log.info(EXIT_MESSAGE);
		}
	}
}
