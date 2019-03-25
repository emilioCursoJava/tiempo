/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import es.evelb.model.Bbox;
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;
import es.evelb.repository.GeoNameRepository;

@Service
public class GeoNameServiceImpl implements GeoNameService {

	Logger logger = LoggerFactory.getLogger(GeoNameServiceImpl.class);

	@Autowired
	GeoNameRepository geoNameRepository;
	
	
	/* (non-Javadoc)
	 * @see es.evelb.repository.GeoNameRepository#getGeoNamesSearchResult(java.lang.String)
	 */
	public GeoNamesSearchResult getGeoNamesSearchResult(String nombre) {
		try {
			logger.info("Realizando petición de GeoNamesSearchResult con nombre de ciudad " + nombre);
			GeoNamesSearchResult gnsr = geoNameRepository.getGeoNamesSearchResult(nombre);
			logger.info(
					"Petición de geoNamesSearchResult con nombre de ciudad "+ nombre+ "Realizada correctamente");
			return gnsr;

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
	 * @see es.evelb.service.GeoNameService#getFirstGeoName(es.evelb.model.GeoNamesSearchResult)
	 */
	public GeoName getFirstGeoName(GeoNamesSearchResult geoNamesSearchResult) {
		logger.info("Realizando petición de getFirstGeoName al geoNamesSearchResult con resultados : " + geoNamesSearchResult.getTotalResultsCount());
		GeoName gn = geoNameRepository.getFirstGeoName(geoNamesSearchResult);
		logger.info("Realizando petición de getFirstGeoName al geoNamesSearchResult realizada correctamente");
		return gn;
	}

	/* (non-Javadoc)
	 * @see es.evelb.service.GeoNameService#getBbox(es.evelb.model.GeoName)
	 */
	public Bbox getBbox(GeoName geoName) {
		logger.info("Realizando petición de getBbox al geoName con resultados : " + geoName.getName());
		Bbox bbox = geoNameRepository.getBbox(geoName);
		logger.info("Realizando petición de getBbox al geoName realizada correctamente");
		return bbox;

	}

}
