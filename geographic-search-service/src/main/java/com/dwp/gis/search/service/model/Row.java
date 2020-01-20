package com.dwp.gis.search.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Row bean
 * 
 * @author Roger.Gale
 * 
 **/
public class Row {

	private List<Element> elements = new ArrayList<Element>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public Row() {}
	
	/**
	*
	* @param elements
	*/
	public Row(List<Element> elements) {
		super();
		this.elements = elements;
	}
	
	public List<Element> getElements() {
		return elements;
	}
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
	
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}