/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase GeoName representa una ciudad con sus coordenadas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoName  {

	/** Name. */
	private String name;
	
	/** Country name. */
	private String countryName;
	
	/** Lat. */
	private Double lat;

	/** Lng. */
	private Double lng;

	/** Bbox. */
	private Bbox bbox;
	
	/**
	 * Instancia un novo obxeto {@link GeoName}.
	 */
	public GeoName() {
	}
 
	/**
	 * Obtiene el name.
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece o name.
	 *
	 * @param name novo valor para name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtiene el country name.
	 *
	 * @return country name
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Establece o country name.
	 *
	 * @param countryName novo valor para country name
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Obtiene el lng.
	 *
	 * @return lng
	 */
	public Double getLng() {
		return lng;
	}

	/**
	 * Establece o lng.
	 *
	 * @param lng novo valor para lng
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}

	/**
	 * Obtiene el lat.
	 *
	 * @return lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * Establece o lat.
	 *
	 * @param lat novo valor para lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * Obtiene el bbox.
	 *
	 * @return bbox
	 */
	public Bbox getBbox() {
		return bbox;
	}

	/**
	 * Establece o bbox.
	 *
	 * @param bbox novo valor para bbox
	 */
	public void setBbox(Bbox bbox) {
		this.bbox = bbox;
	}

	
}
