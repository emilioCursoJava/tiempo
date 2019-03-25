/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.evelb.model.Bbox;
import es.evelb.model.GeoName;
import es.evelb.model.GeoNamesSearchResult;
import es.evelb.model.WeatherObservation;
import es.evelb.model.WeatherObservationSearchResult;
import es.evelb.service.GeoNameService;
import es.evelb.service.WeatherObservationService;

/**
 * Clase TiempoController.
 */
@Controller
@Scope("session")
public class TiempoController {
	
	/** Data. */
	List<GeoName> data = new ArrayList<>();
	
	/** Messages. */
	@Autowired
	MessageSource messages;
	
	/** Geo names service. */
	@Autowired
	GeoNameService geoNamesService;

	/** Weather observation service. */
	@Autowired
	WeatherObservationService weatherObservationService;

	/** Lista busquedas. */
	List<String> listaBusquedas = new ArrayList<>();
	
	/**
	 * Función llamada cuando consultamos una ciudad
	 * Mediante POST - Cuando pulsamos consultar en el Formulario principal y recogemos el nombre
	 * Mediante GET -  Cuando pulsamos sobre una ciudad añadida anteriormente 
	 *
	 * @param nombre el nombre
	 * @param model el model
	 * @param locale el locale
	 * @param session el session
	 * @return string
	 */
	@RequestMapping(value = "/consultaTiempo", method = {RequestMethod.GET, RequestMethod.POST})
	public String consultaTiempo(String nombre, Model model, Locale locale,HttpSession session) {
		//Caso especial para cambiar el idioma de la aplicación
		if (nombre == null)
			return "index";
		Bbox bbox = getBboxCiudad(nombre, model);
		if (bbox == null) {
			model.addAttribute("error", messages.getMessage("error.consulta.ciudad", null, locale));
			return "index";
		} else {
			List<WeatherObservation> weathersObservation = getWeathersObservation(bbox, model);
			if (weathersObservation == null || weathersObservation.isEmpty()) {
				model.addAttribute("error", messages.getMessage("error.consulta.sinObservaciones", null, locale));
				return "index";
			} else {
				model.addAttribute("temperatura",weatherObservationService.getTemperaturaMedia(weathersObservation));
				model.addAttribute("humedad",weatherObservationService.getHumedadMedia(weathersObservation));
				model.addAttribute("velocidadViento", weatherObservationService.getVelocidadVientoMedia(weathersObservation) );
			}
			//Si todo esta correcto añadimos a la lista de busquedas solo si no está añadida previamente
			if (!listaBusquedas.contains(nombre))
				listaBusquedas.add(nombre);
			session.setAttribute("listaBusquedas",listaBusquedas);

			return "tiempo";
		}
	}

	/**
	 * Recupera las coordenadas de la ciudad a través de su nombre.
	 *
	 * @param nombre el nombre de la ciudad
	 * @param model el model
	 * @return bbox de coordenadas de la ciudad
	 */
	public Bbox getBboxCiudad(String nombre, Model model) {
		GeoNamesSearchResult geoNamesSearchResult = geoNamesService.getGeoNamesSearchResult(nombre);
		GeoName geoName = geoNamesService.getFirstGeoName(geoNamesSearchResult);
		model.addAttribute("geoName", geoName);
		Bbox bbox = geoNamesService.getBbox(geoName);
		return (bbox);

	}

	/**
	 * Obtiene la lista de observaciones segun unas coordenadas.
	 *
	 * @param bbox coordenadas a buscar
	 * @param model el model
	 * @return list
	 */
	public List<WeatherObservation> getWeathersObservation (Bbox bbox, Model model) {
		WeatherObservationSearchResult weatherObservationSearchResult = weatherObservationService
				.getWeatherObservationSearchResult(bbox);
		List<WeatherObservation> weathersObservation = weatherObservationService
				.getWeatherObservations(weatherObservationSearchResult);
		model.addAttribute("weathersObservation", weathersObservation);
		return weathersObservation;
	}
	
}
