/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clase IndexController.
 */
@Controller
@Scope("session")
public class IndexController {
	
	
	/**
	 * Llamada a Index cuando volvemos a la pagina principal
	 *
	 * @param model el model
	 * @param session el session
	 * @return string
	 */
	@RequestMapping(value = { "/", "/tiempo" }, method = RequestMethod.GET)
	String index(Model model,HttpSession  session) {
		return "index";
	}

	
}

