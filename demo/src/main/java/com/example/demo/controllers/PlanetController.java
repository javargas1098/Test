package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import com.example.demo.documents.Planet;
import com.example.demo.services.PersonService;
import com.example.demo.services.PlanetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planet")
public class PlanetController {

    private static final Logger logger = Logger.getLogger(PlanetController.class.getName());
    private static final String ERROR = "Error";

    @Autowired
    PersonService personService;

    @Autowired
    PlanetService planetService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Planet>> allCars() {
        try {
            List<Planet> persons = planetService.findAll();
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Planet>> employeesById(@PathVariable("id") String id) {
        try {
            Optional<Planet> planet = planetService.findById(id);
            return new ResponseEntity<>(planet, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find3")
    public ResponseEntity<List<Planet>> findBestPerosns() {
        try {
            List<Planet> planets = planetService.findBestPlanets();
            return new ResponseEntity<>(planets, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> insertPlanet(@RequestBody Planet planet) {
        if (planetService.findById(planet.getId()).isPresent()) {
            return new ResponseEntity<>("el empleado ya existe", HttpStatus.FORBIDDEN);

        } else {
            planetService.addPlanet(planet);
            return new ResponseEntity<>("creado exitosamente", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/createall")
    @Transactional
    public ResponseEntity<String> insertEmployee(@RequestBody List<Planet> planets) {
        planets.forEach(planet -> {
            insertPlanet(planet);
        });
        return new ResponseEntity<>("Planetas " + " creados exitosamente", HttpStatus.OK);
    }
}