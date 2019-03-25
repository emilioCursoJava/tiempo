/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.evelb.model.Bbox;
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;

/**
 * Clase GeoNameServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class GeoNameServiceTest {

	/** Constante MADRID. */
	public static final String MADRID = "Madrid";

	/** Geo name service. */
	@Autowired
	private GeoNameService geoNameService;

	/**
	 * Prueba el geo names search result .
	 *
	 * @return geo names search result 
	 */
	@Test
	public void getGeoNamesSearchResultTest() {
		GeoNamesSearchResult gsr = geoNameService.getGeoNamesSearchResult(MADRID);
		Assert.assertTrue(gsr.getTotalResultsCount() > 0);
	}

	/**
	 * Prueba el first geo name.
	 *
	 * @return first geo name
	 */
	@Test
	public void getFirstGeoName () {
		GeoNamesSearchResult geoNamesSearchResult = geoNameService.getGeoNamesSearchResult(MADRID);
		GeoName geoName = geoNameService.getFirstGeoName(geoNamesSearchResult);
		Assert.assertTrue(MADRID.equals(geoName.getName()));
	}

	/**
	 * Prueba get bbox.
	 *
	 * @return bbox
	 */
	@Test
	public void getBbox() {		
		GeoNamesSearchResult geoNamesSearchResult = geoNameService.getGeoNamesSearchResult(MADRID);
		GeoName geoName = geoNameService.getFirstGeoName(geoNamesSearchResult);
		Bbox bbox = geoNameService.getBbox(geoName);
		Assert.assertTrue(bbox != null);
	}

}
