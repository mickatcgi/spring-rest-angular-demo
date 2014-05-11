package com.micks.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/***************************************************************
 * Application.class is the entry point for a Spring app and 
 * in this mode it lets us run a web app as a regular application
 * inside a java jar file with an embedded app server instead of 
 * having to build a WAR file and deploy to an external app server.
 * 
 * @author mick
 *
 ***************************************************************/
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
