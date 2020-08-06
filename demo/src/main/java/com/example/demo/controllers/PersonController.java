package com.example.demo.controllers;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import com.example.demo.documents.Person;
import com.example.demo.services.PersonService;

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
@RequestMapping("person")
public class PersonController {

    private static final Logger logger = Logger.getLogger(PersonController.class.getName());
    private static final String ERROR = "Error";

    @Autowired
    PersonService personService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Person>> allPersons() {
        try {
            List<Person> persons = personService.findAll();
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{type}/{card}")
    public ResponseEntity<Optional<Person>> personsById(@PathVariable("type") String type,
            @PathVariable("card") int card) {
        try {
            Optional<Person> person = personService.findById(type, card);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find3")
    public ResponseEntity<List<Person>> findBestPerosns() {
        try {
            List<Person> persons = personService.findBestPersons();
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, ERROR, e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> insertPerson(@RequestBody Person person) {
        if (personService.findById(person.getPersonId().getType(), person.getPersonId().getCard()).isPresent()) {
            return new ResponseEntity<>("el empleado ya existe", HttpStatus.FORBIDDEN);

        } else {
            personService.addPerson(person);
            return new ResponseEntity<>("creado exitosamente", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/createall")
    @Transactional
    public ResponseEntity<String> insertPersons(@RequestBody List<Person> persons) {
        persons.forEach(person->{
            insertPerson(person);
        });
        return new ResponseEntity<>("Perosnas " + " creadas exitosamente", HttpStatus.OK);
    }

}