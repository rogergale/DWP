package com.dwp.gis.search.service.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Element bean
 * 
 * @author Roger.Gale
 * 
 **/
public class Element {

	private Distance distance;
	private Duration duration;
	private String status;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public Element() {}
	
	/**
	*
	* @param duration
	* @param distance
	* @param status
	*/
	public Element(Distance distance, Duration duration, String status) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.status = status;
	}
	
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}