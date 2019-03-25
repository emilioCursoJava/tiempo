/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.model;


/**
 * Clase WeatherObservation que representa una observacion de tiempo de una estacion concreta .
 */
public class WeatherObservation {

	/** Station name. */
	private String stationName;
	
	/** Temperature. */
	private Double temperature;
	
	/** Humidity. */
	private Integer humidity;
	
	/** Wind speed. */
	private Integer windSpeed;
	
	/** Lng. */
	private double lng;
	
	/** Lat. */
	private double lat;

	/**
	 * Obtiene el station name.
	 *
	 * @return station name
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * Establece o station name.
	 *
	 * @param stationName novo valor para station name
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * Obtiene el temperature.
	 *
	 * @return temperature
	 */
	public Double getTemperature() {
		return temperature;
	}

	/**
	 * Establece o temperature.
	 *
	 * @param temperature novo valor para temperature
	 */
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	/**
	 * Obtiene el humidity.
	 *
	 * @return humidity
	 */
	public Integer getHumidity() {
		return humidity;
	}

	/**
	 * Establece o humidity.
	 *
	 * @param humidity novo valor para humidity
	 */
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	/**
	 * Obtiene el wind speed.
	 *
	 * @return wind speed
	 */
	public Integer getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Establece o wind speed.
	 *
	 * @param windSpeed novo valor para wind speed
	 */
	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * Obtiene el lng.
	 *
	 * @return lng
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * Establece o lng.
	 *
	 * @param lng novo valor para lng
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}

	/**
	 * Obtiene el lat.
	 *
	 * @return lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Establece o lat.
	 *
	 * @param lat novo valor para lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

}
