package com.dwp.gis.search.service.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Distance bean
 * 
 * @author Roger.Gale
 * 
 **/
public class Distance {

	private String text;
	private Integer value;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public Distance() {}
	
	/**
	*
	* @param text
	* @param value
	*/
	public Distance(String text, Integer value) {
		super();
		this.text = text;
		this.value = value;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}