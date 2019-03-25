/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.evelb.model.Bbox;
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;

/**
 * Clase WeatherObservationServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherObservationServiceTest {

	/** Constante MADRID. */
	public static final String MADRID = "Madrid";
	
	/** Gsr. */
	GeoNamesSearchResult gsr;
	
	/** Name. */
	GeoName name;
	
	/** Bbox. */
	Bbox bbox;

	/** Weather observation service. */
	@Autowired
	private WeatherObservationService weatherObservationService;

	/** Geo name service. */
	@Autowired
	private GeoNameService geoNameService;

	/**
	 * Establece el up test. Cargando los datos necesarios del servicio
	 */
	@Before
	public void setUpTest() {
		gsr = geoNameService.getGeoNamesSearchResult(MADRID);
		name = geoNameService.getFirstGeoName(gsr);
		bbox = geoNameService.getBbox(name);
	}

	/**
	 * prueba el get geo names search result test.
	 *
	 * @return geo names search result test
	 */
	@Test
	public void getGeoNamesSearchResultTest() {

		WeatherObservationSearchResult woh = weatherObservationService.getWeatherObservationSearchResult(bbox);
		Assert.assertTrue(woh.getWeatherObservations().size() > 0);
	}

	/**
	 * Prueba el temperatura media test.
	 *
	 * @return temperatura media test
	 */
	@Test
	public void getTemperaturaMediaTest() {
		WeatherObservationSearchResult woh = weatherObservationService.getWeatherObservationSearchResult(bbox);
		List<WeatherObservation> listWeatherObservation = woh.getWeatherObservations();
		Assert.assertTrue(weatherObservationService.getTemperaturaMedia(listWeatherObservation) != null);
	}

	/**
	 * Prueba el humedad media test.
	 *
	 * @return humedad media test
	 */
	@Test
	public void getHumedadMediaTest() {
		WeatherObservationSearchResult woh = weatherObservationService.getWeatherObservationSearchResult(bbox);
		List<WeatherObservation> listWeatherObservation = woh.getWeatherObservations();
		Assert.assertTrue(weatherObservationService.getHumedadMedia(listWeatherObservation) != null);

	}

	/**
	 * Prueba el velocidad viento test.
	 *
	 * @return velocidad viento test
	 */
	@Test
	public void getVelocidadVientoTest() {
		WeatherObservationSearchResult woh = weatherObservationService.getWeatherObservationSearchResult(bbox);
		List<WeatherObservation> listWeatherObservation = woh.getWeatherObservations();
		Assert.assertTrue(weatherObservationService.getVelocidadVientoMedia(listWeatherObservation) != null);

	}

}
