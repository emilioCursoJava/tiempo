/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.repository;

import es.evelb.model.Bbox;
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;

/**
 * Interfaz que recupera los datos de una ciudad.
 */
public interface GeoNameRepository {

	/**
	 * Obtiene el GeoNamesSearchResult.
	 *
	 * @param nombre el nombre
	 * @return geo names search result
	 */
	public GeoNamesSearchResult getGeoNamesSearchResult (String nombre);
	

	/**
	 * Obtiene el primer GeoName (ciudad) de la busqueda
	 *
	 * @param geoNamesSearchResult el geo names search result
	 * @return first geo name
	 */
	public GeoName getFirstGeoName(GeoNamesSearchResult geoNamesSearchResult);

	/**
	 * Obtiene el bbox (coordenadas) de un GeoName .
	 *
	 * @param geoName el geo name
	 * @return bbox
	 */
	public Bbox getBbox(GeoName geoName);
	
	
}
