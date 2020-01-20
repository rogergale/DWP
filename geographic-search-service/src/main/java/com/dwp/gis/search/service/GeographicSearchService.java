package com.dwp.gis.search.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.dwp.gis.search.service.model.Users;

/**
 * 
 * Geographic Search Service Interface
 * 
 * @author Roger.Gale
 * 
 **/
public interface GeographicSearchService {
        ResponseEntity<Users> getUsers(@PathVariable("city") String city, @PathVariable("radius") String radius);
}
