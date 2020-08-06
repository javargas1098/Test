package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.documents.Planet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {

	@Query(value = "UPDATE planetas SET clicks = :clicks WHERE id=:id", nativeQuery = true)
	@Modifying(clearAutomatically = true)
	@Transactional
	void addClicks(@Param("id") String id, @Param("clicks") int clicks);

	@Query(value = "SELECT clicks FROM planetas WHERE id=:id", nativeQuery = true)
	int getClicks(@Param("id") String id);

	@Query(value = "SELECT * FROM planetas order by clicks desc limit 3", nativeQuery = true)
    List<Planet> findPlanets();

}