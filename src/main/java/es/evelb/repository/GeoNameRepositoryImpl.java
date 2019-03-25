/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.repository;

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
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;

/**
 * Clase GeoNameRepositoryImpl.
 */
@Repository
public class GeoNameRepositoryImpl implements GeoNameRepository {

	/** Logger. */
	Logger logger = LoggerFactory.getLogger(WeatherObservationRepositoryImpl.class);
	private static final String urlSearchCity = "http://api.geonames.org/searchJSON?";

	/** Env. */
	@Autowired
    private Environment env;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.evelb.repository.GeoNameRepository#getGeoNamesSearchResult(java.lang.
	 * String)
	 */
	public GeoNamesSearchResult getGeoNamesSearchResult(String nombre) {
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlSearchCity).queryParam("q", nombre)
					.queryParam("maxRows", "20").queryParam("startRow", "0").queryParam("lang", "en")
					.queryParam("isNameRequired", "20").queryParam("style", "FULL")
					.queryParam("username", env.getProperty("user.api.geonames"));

			RestTemplate restTemplate = new RestTemplate();
			// RestTemplate
			GeoNamesSearchResult geoNamesSearchResult = restTemplate.getForObject(builder.toUriString(),
					GeoNamesSearchResult.class);
			return geoNamesSearchResult;

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

	/* (non-Javadoc)
	 * @see es.evelb.repository.GeoNameRepository#getFirstGeoName(es.evelb.model.GeoNamesSearchResult)
	 */
	public GeoName getFirstGeoName(GeoNamesSearchResult geoNamesSearchResult) {

		if (geoNamesSearchResult != null && geoNamesSearchResult.getGeonames() != null
				&& !geoNamesSearchResult.getGeonames().isEmpty()) {
			return geoNamesSearchResult.getGeonames().get(0);
		} else {
			return new GeoName();
		}
	}

	/* (non-Javadoc)
	 * @see es.evelb.repository.GeoNameRepository#getBbox(es.evelb.model.GeoName)
	 */
	public Bbox getBbox(GeoName geoName) {

		if (geoName != null)
			return geoName.getBbox();
		else {
			return new Bbox();
		}
	}

}
