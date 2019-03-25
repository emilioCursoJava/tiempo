/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import es.evelb.model.Bbox;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;
import es.evelb.repository.WeatherObservationRepository;

/**
 * Implementación de {@link WeatherObservationService}.
 */
@Service
public class WeatherObservationServiceImpl implements WeatherObservationService {

	
	/** Logger. */
	Logger logger = LoggerFactory.getLogger(WeatherObservationServiceImpl.class);
	
	
	/** Weather observation repository. */
	@Autowired
	private WeatherObservationRepository weatherObservationRepository;
	
	/* (non-Javadoc)
	 * @see es.evelb.repository.WeatherObservationRepository#getWeatherObservationSearchResult(es.evelb.model.Bbox)
	 */
	public WeatherObservationSearchResult getWeatherObservationSearchResult(Bbox bbox) {
		try {
			logger.info("Realizando petición de weatherObservation mediante bbox");
	
			WeatherObservationSearchResult wor = weatherObservationRepository.getWeatherObservationSearchResult(bbox);
			logger.info(
					"Petición de weatherObservation Realizada correctamente");
			return wor;

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
	 * @see es.evelb.service.WeatherObservationService#getWeatherObservations(es.evelb.model.WeatherObservationSearchResult)
	 */
	public List<WeatherObservation> getWeatherObservations(		
			WeatherObservationSearchResult weatherObservationSearchResult) {
		logger.info("Realizando petición de getWeatherObservations al weatherObservationSearchResult" );
		List<WeatherObservation> listWeatherObservation = weatherObservationRepository.getWeatherObservations(weatherObservationSearchResult);
		logger.info(
				"Petición de getWeatherObservations Realizada correctamente");
		return listWeatherObservation;
	}
	
	/* (non-Javadoc)
	 * @see es.evelb.service.WeatherObservationService#getTemperaturamedia(java.util.List)
	 */
	public Double getTemperaturaMedia (List<WeatherObservation> weathersObservation) {
		Double temp = 0.0;
		Integer sizeTemp = weathersObservation.size();
		for (int i = 0; i < weathersObservation.size(); i++) {
			if (null == weathersObservation.get(i).getTemperature()
					|| "".equals(weathersObservation.get(i).getTemperature())) {
				sizeTemp = sizeTemp - 1;
			} else {
				temp = temp + weathersObservation.get(i).getTemperature();
			}
		}
		temp = temp/sizeTemp;
		return limitPrecision( temp ,1);
	}

	/* (non-Javadoc)
	 * @see es.evelb.service.WeatherObservationService#getHumedadMedia(java.util.List)
	 */
	public Integer getHumedadMedia (List<WeatherObservation> weathersObservation) {
		Integer humedad = 0;
		Integer sizeHumedad = weathersObservation.size();
		for (int i = 0; i < weathersObservation.size(); i++) {
			if (weathersObservation.get(i).getHumidity() == null
					|| "".equals(weathersObservation.get(i).getHumidity())) {
				sizeHumedad = sizeHumedad - 1;
			} else {
				humedad = humedad + weathersObservation.get(i).getHumidity();
			}
		}
		humedad = humedad / sizeHumedad;
		return humedad;
	}
	
	
	/* (non-Javadoc)
	 * @see es.evelb.service.WeatherObservationService#getVelocidadVientoMedia(java.util.List)
	 */
	public Integer getVelocidadVientoMedia (List<WeatherObservation> weathersObservation) {
		Integer velocidadViento = 0;
		Integer sizeVelViento = weathersObservation.size();
		for (int i = 0; i < weathersObservation.size(); i++) {
			if (weathersObservation.get(i).getWindSpeed() == null
					|| "".equals(weathersObservation.get(i).getWindSpeed())) {
				sizeVelViento = sizeVelViento - 1;
			} else {
				velocidadViento = velocidadViento + weathersObservation.get(i).getWindSpeed();
			}
		}
		velocidadViento = velocidadViento / sizeVelViento;
		return velocidadViento;

	}
	
	
	/**
	 * Limit precision. Nos ayuda con la precisión de los double de la temperatura
	 *
	 * @param value el value
	 * @param maxDigitsAfterDecimal el máximo digits after decimal
	 * @return double
	 */
	public double limitPrecision(Double value, int maxDigitsAfterDecimal) {
	    int multiplier = (int) Math.pow(10, maxDigitsAfterDecimal);
	    return  ((value) * multiplier) / multiplier;
}

}
