package com.dwp.gis.search.service.compute;

import com.dwp.gis.search.service.exceptions.TechnicalFailureException;
import com.dwp.gis.search.service.model.Users;

/**
 * 
 * GeographicSearchServiceProcessor Interface
 * 
 * @author Roger.Gale
 * 
 **/
public interface IGeographicSearchServiceProcessor {
	public Users getUsers(String city, String radius) throws TechnicalFailureException;
}
