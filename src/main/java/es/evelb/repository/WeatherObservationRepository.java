/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.repository;

import java.util.List;

import es.evelb.model.Bbox;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;

/**
 * Interfaz que recupera el weather del servicio.
 */
public interface WeatherObservationRepository {

	/**
	 * Obtiene el resultado de la búsqueda de weather observation segun las coordenadas dadas.
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

}
