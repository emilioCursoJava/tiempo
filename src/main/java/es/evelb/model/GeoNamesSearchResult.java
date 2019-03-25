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
 * Clase GeoNamesSearchResult que representa los resultados de la busqueda de una ciudad.
 */
public class GeoNamesSearchResult {

    /** Total results count. */
    private int totalResultsCount;
    
    /** Geonames. */
    private List<GeoName> geonames = new ArrayList<GeoName>();

    /**
     * Obtiene el total results count.
     *
     * @return total results count
     */
    public int getTotalResultsCount() {
        return totalResultsCount;
    }

    /**
     * Establece o total results count.
     *
     * @param totalResultsCount novo valor para total results count
     */
    public void setTotalResultsCount(int totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    /**
     * Obtiene el geonames.
     *
     * @return geonames
     */
    public List<GeoName> getGeonames() {
        return geonames;
    }
}