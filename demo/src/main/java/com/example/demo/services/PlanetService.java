package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.documents.Planet;
import com.example.demo.repositories.PlanetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    @Autowired
    PlanetRepository planetRepository;

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public Optional<Planet> findById(String id) {
        return planetRepository.findById(id);
    }

    public void addclicks(String id, int clicks) {
        planetRepository.addClicks(id, clicks);

    }

    public int getclicks(String id) {
        return planetRepository.getClicks(id);
    }

    public void addPlanet(Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> findBestPlanets() {
        return planetRepository.findPlanets();
    }
}