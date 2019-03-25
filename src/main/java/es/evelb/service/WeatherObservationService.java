/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.service;

import java.util.List;

import es.evelb.model.Bbox;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;

/**
 * Interfaz para obtener los datos metereologicos dados unas coordenadas (bbox).
 */
public interface WeatherObservationService {

	/**
	 * Obtiene el resultado de la búsqueda de weather observation segun las
	 * coordenadas dadas.
	 *
	 * @param bbox el bbox (coordenadas)
	 * @return geo names search result
	 */
	public WeatherObservationSearchResult getWeatherObservationSearchResult(Bbox bbox);

	/**
	 * Obtiene una lista de WeatherObservation es decir de observaciones
	 * metereológicas
	 *
	 * @param weatherObservationSearchResult el weather observation search result
	 * @return weather observations
	 */
	public List<WeatherObservation> getWeatherObservations(
			WeatherObservationSearchResult weatherObservationSearchResult);

	/**
	 * Obtiene la temperatura media de una lista de observaciones de diferentes estaciones.
	 *
	 * @param weathersObservation  weathers observation (observaciones metereologicas)
	 * @return temperatura media
	 */
	public Double getTemperaturaMedia (List<WeatherObservation> weathersObservation);
	
	/**
	 * Obtiene la humedad media de una lista de observaciones de diferentes estaciones.
	 *
	 * @param weathersObservation weathers observation (observaciones metereologicas)
	 * @return humedad media
	 */
	public Integer getHumedadMedia (List<WeatherObservation> weathersObservation);
	
	/**
	 * Obtiene la velocidad viento media de una lista de observaciones de diferentes estaciones.
	 *
	 * @param weathersObservation el weathers observation
	 * @return velocidad viento media
	 */
	public Integer getVelocidadVientoMedia (List<WeatherObservation> weathersObservation);

}
