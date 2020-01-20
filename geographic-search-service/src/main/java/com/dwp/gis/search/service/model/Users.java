package com.dwp.gis.search.service.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Users bean
 * 
 * @author Roger.Gale
 * 
 **/
public class Users {
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("radius")
	private String radius;
	
	@JsonProperty("users")
	private List<User> users;
	
	@JsonProperty("message")
	private String message;
	
	public Users() {
		this.users = new ArrayList<User>();
	}
	
	public Users(String city, String radius, String message) {
		super();
		this.city = city;
		this.radius = radius;
		this.message = message; 
	}
	
	public Users(String city, String radius, List<User> users) {
		super();
		this.city = city;
		this.radius = radius;
		this.users = users;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}

	public List<User> getUsers() {
		return users;
	} 
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
