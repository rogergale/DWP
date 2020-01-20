package com.dwp.gis.search.service.compute;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dwp.gis.search.service.IUserService;
import com.dwp.gis.search.service.exceptions.TechnicalFailureException;
import com.dwp.gis.search.service.model.Users;
import com.dwp.gis.search.service.model.User;

/**
 * Geographic Search Service Processor
 * 
 * @author Roger.Gale
 *
 */
@Component("GeographicSearchServiceProcessor")
public class GeographicSearchServiceProcessor implements IGeographicSearchServiceProcessor {
		
	@Autowired
	IUserService userService;
	
	public Users getUsers(String city, String radius) throws TechnicalFailureException {		
		List<User> userList = new ArrayList<User>();
		userList = userService.getUsers(city, radius);
		return new Users(city, radius, userList);
	}
	
}
