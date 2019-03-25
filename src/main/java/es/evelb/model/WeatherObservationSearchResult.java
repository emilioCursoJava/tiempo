/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase WeatherObservationSearchResult que representa las diferentes observaciones encontradas segun unas coordenadas.
 */
public class WeatherObservationSearchResult {

	/** Weather observations. */
	private  List<WeatherObservation> weatherObservations = new ArrayList <WeatherObservation>();

	/**
	 * Obtiene el weather observations.
	 *
	 * @return weather observations
	 */
	public List<WeatherObservation> getWeatherObservations() {
		return weatherObservations;
	}

	/**
	 * Establece el weather observation.
	 *
	 * @param weatherObservations novo valor para weather observation
	 */
	public void setWeatherObservation(List<WeatherObservation> weatherObservations) {
		this.weatherObservations = weatherObservations;
	}
	
}
