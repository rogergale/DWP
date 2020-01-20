package com.dwp.gis.search.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Google Distance Matrix bean
 * 
 * @author Roger.Gale
 * 
 **/
public class GoogleDistanceMatrix {

	private List<String> destinationAddresses = new ArrayList<String>();
	private List<String> originAddresses = new ArrayList<String>();
	private List<Row> rows = new ArrayList<Row>();
	private String status;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public GoogleDistanceMatrix() {}
	
	/**
	*
	* @param originAddresses
	* @param destinationAddresses
	* @param rows
	* @param status
	*/
	public GoogleDistanceMatrix(List<String> destinationAddresses, List<String> originAddresses, List<Row> rows, String status) {
		super();
		this.destinationAddresses = destinationAddresses;
		this.originAddresses = originAddresses;
		this.rows = rows;
		this.status = status;
	}
	
	public List<String> getDestinationAddresses() {
		return destinationAddresses;
	}
	public void setDestinationAddresses(List<String> destinationAddresses) {
		this.destinationAddresses = destinationAddresses;
	}
	
	public List<String> getOriginAddresses() {
		return originAddresses;
	}
	public void setOriginAddresses(List<String> originAddresses) {
		this.originAddresses = originAddresses;
	}
	
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
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