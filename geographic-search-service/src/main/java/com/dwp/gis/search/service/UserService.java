package com.dwp.gis.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dwp.gis.search.service.model.Element;
import com.dwp.gis.search.service.model.GoogleDistanceMatrix;
import com.dwp.gis.search.service.model.Row;
import com.dwp.gis.search.service.model.User;

/**
 * 
 * User Service 
 * 
 * @param city
 * @param radius
 * @return Users
 * 
 * @author Roger.Gale
 * 
 **/
@Component("UserService")
public class UserService implements IUserService {

	private List<User> cityUsers = new ArrayList<User>();
	private List<User> allUsers = new ArrayList<User>();
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<User> getUsers(String city, String radius) {
		cityUsers = getCityUsers(city, restTemplate);
		allUsers = getAllUsers(restTemplate);
	    addUsersWithinRadius(city, radius, cityUsers, restTemplate, allUsers);
		return cityUsers;
	}

	private void addUsersWithinRadius(String city, String radius, List<User> cityUsers, RestTemplate restTemplate,
			List<User> allUsers) {
		final String apiKey = "GoogleAPIKeyRequired";
		String uriGoogleDistanceMatrix;
		String latitude;
		String longitude;
		ResponseEntity<GoogleDistanceMatrix> responseEntityGoogle;
		GoogleDistanceMatrix googleDistanceMatrix;
		for (User user: allUsers) {
	    	latitude = user.getLatitude();
	    	longitude = user.getLongitude();
	    	uriGoogleDistanceMatrix = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=" 
	    								+ city + "&destinations=" + latitude + "," + longitude + "&key=" + apiKey;
	    	responseEntityGoogle = restTemplate.exchange(uriGoogleDistanceMatrix, HttpMethod.GET, 
		    		null, new ParameterizedTypeReference<GoogleDistanceMatrix>() {
		    });
	    	googleDistanceMatrix = responseEntityGoogle.getBody();
	    	List<Row> rows = googleDistanceMatrix.getRows();
	    	Row row = rows.get(0);
	    	List<Element> elements = row.getElements();
	    	Element element = elements.get(0);
	    	if (!element.getStatus().equals("ZERO_RESULTS")) {
	    		String distance = element.getDistance().getText();
		    	if (Double.parseDouble(distance.substring(0, distance.length() -3).replaceAll(",", "")) 
		    			<= Double.parseDouble(radius)) {
		    		cityUsers.add(user);
		    	}
	    	} 
	    }
	}

	private List<User> getAllUsers(RestTemplate restTemplate) {
		ResponseEntity<List<User>> responseEntity;
		List<User> allUsers;
		final String uriAllUsers = "https://bpdts-test-app.herokuapp.com/users";
	    responseEntity = restTemplate.exchange(uriAllUsers, HttpMethod.GET, 
	    		null, new ParameterizedTypeReference<List<User>>() {
	    });
	    allUsers = responseEntity.getBody();
		return allUsers;
	}

	private List<User> getCityUsers(String city, RestTemplate restTemplate) {
		ResponseEntity<List<User>> responseEntity;
		List<User> cityUsers;
		final String uriCityUsers = "https://bpdts-test-app.herokuapp.com/city/" + city + "/users";
	    responseEntity = restTemplate.exchange(uriCityUsers, HttpMethod.GET, 
	    		null, new ParameterizedTypeReference<List<User>>() {
	    });
	    cityUsers = responseEntity.getBody();
		return cityUsers;
	}
	
}
