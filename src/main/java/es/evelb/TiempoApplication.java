/*
 * Copyright 2018
 * 
 * Author: Emilio Domínguez
 * Proyecto: Prueba técnica Evelb - Consulta el tiempo
 * 
 */
package es.evelb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase TiempoApplication.
 */
@SpringBootApplication
public class TiempoApplication extends SpringBootServletInitializer{

    /* (non-Javadoc)
     * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TiempoApplication.class);
    }

    /**
     * Método principal.
     *
     * @param args argumentos
     * @throws Exception si se produce unha excepción
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TiempoApplication.class, args);
    }
}
