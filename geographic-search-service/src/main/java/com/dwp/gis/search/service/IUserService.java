package com.dwp.gis.search.service;

import java.util.List;

import com.dwp.gis.search.service.model.User;

/**
 * 
 * User Service Interface
 * 
 * @author Roger.Gale
 * 
 **/
public interface IUserService {
	List<User> getUsers(String city, String radius);
}
