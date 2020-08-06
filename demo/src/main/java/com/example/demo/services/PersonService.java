package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.documents.Person;
import com.example.demo.documents.utils.PersonId;
import com.example.demo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(String type, int card) {
        return personRepository.findById(new PersonId(type, card));
    }

    public List<Person> findBestPersons() {
        return personRepository.findPersons();
    }

    public void addclicks(String type, int card, int clicks) {
        personRepository.addClicks(card, type, clicks);

    }

    public int getclicks(String type, int card) {
        return personRepository.getClicks(card, type);
    }

	public void addPerson(Person person) {
        personRepository.save(person);
    }
    
    public List<Person> findPlanetPersons(String id) {
        return personRepository.findPlanetPersons(id);
    }

}