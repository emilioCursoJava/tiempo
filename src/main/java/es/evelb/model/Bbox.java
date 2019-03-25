/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase Bbox representa las coordenadas de una ciudad
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bbox {

	/** East. */
	private Double east;
	
	/** South. */
	private Double south;
	
	/** North. */
	private Double north;
	
	/** West. */
	private Double west;

	/**
	 * Instancia un nuevo objeto {@link Bbox}.
	 */
	public Bbox () {
		
	}
	
	/**
	 * Obtiene el east.
	 *
	 * @return east
	 */
	public Double getEast() {
		return east;
	}

	/**
	 * Establece el east.
	 *
	 * @param east nuevo valor para east
	 */
	public void setEast(Double east) {
		this.east = east;
	}

	/**
	 * Obtiene el south.
	 *
	 * @return south
	 */
	public Double getSouth() {
		return south;
	}

	/**
	 * Establece el south.
	 *
	 * @param south nuevo valor para south
	 */
	public void setSouth(Double south) {
		this.south = south;
	}

	/**
	 * Obtiene el north.
	 *
	 * @return north
	 */
	public Double getNorth() {
		return north;
	}

	/**
	 * Establece el north.
	 *
	 * @param north novo valor para north
	 */
	public void setNorth(Double north) {
		this.north = north;
	}

	/**
	 * Obtiene el west.
	 *
	 * @return west
	 */
	public Double getWest() {
		return west;
	}

	/**
	 * Establece o weast.
	 *
	 * @param west novo valor para weast
	 */
	public void setWeast(Double west) {
		this.west = west;
	}
	
	
	
}
