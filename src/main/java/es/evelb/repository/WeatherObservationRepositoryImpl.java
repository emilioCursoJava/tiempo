/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.repository;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import es.evelb.model.Bbox;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;

/**
 * Clase que llama al servicio rest .
 */
@Repository
public class WeatherObservationRepositoryImpl implements WeatherObservationRepository {

	/** Logger. */
	Logger logger = LoggerFactory.getLogger(WeatherObservationRepositoryImpl.class);
	
	/** Constante urlSearchWeather. */
	private static final String urlSearchWeather = "http://api.geonames.org/weatherJSON?";

	/** Env. */
	@Autowired
    private Environment env;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.evelb.repository.WeatherObservationRepository#
	 * getWeatherObservationSearchResult(es.evelb.model.Bbox)
	 */
	public WeatherObservationSearchResult getWeatherObservationSearchResult(Bbox bbox) {
		try {
			//Se construye la url para obtener el JSON correspondiente
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlSearchWeather).queryParam("north", bbox.getNorth())
					.queryParam("south", bbox.getSouth()).queryParam("east", bbox.getEast())
					.queryParam("west", bbox.getWest()).queryParam("username", env.getProperty("user.api.geonames"));

			RestTemplate restTemplate = new RestTemplate();

			// Con el JSON se transforma a WeatherObservationSearchResult
			WeatherObservationSearchResult weatherObservationSearchResult = restTemplate
					.getForObject(builder.toUriString(), WeatherObservationSearchResult.class);
			return weatherObservationSearchResult;

		} catch (HttpClientErrorException http) {
			logger.error("HTTP status 400 en la petición de WeatherObservationSearchResult");
			throw http;

		} catch (HttpServerErrorException http) {
			logger.error("HTTP status 500 en la petición de WeatherObservationSearchResult");
			throw http;

		} catch (UnknownHttpStatusCodeException http) {
			logger.error("Http error code desconocido en la petición de WeatherObservationSearchResult");
			throw http;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.evelb.repository.WeatherObservationRepository#getWeatherObservations(es.
	 * evelb.model.WeatherObservationSearchResult)
	 */
	public List<WeatherObservation> getWeatherObservations(
			WeatherObservationSearchResult weatherObservationSearchResult) {
		if (weatherObservationSearchResult != null
				&& !weatherObservationSearchResult.getWeatherObservations().isEmpty()) {
			return weatherObservationSearchResult.getWeatherObservations();
		} else {
			return Collections.emptyList();
		}
	}

}
