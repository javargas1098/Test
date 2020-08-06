package com.example.demo.repositories;

import java.util.List;

import com.example.demo.documents.Person;
import com.example.demo.documents.utils.PersonId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query(value = "SELECT * FROM personas order by clicks desc limit 3", nativeQuery = true)
    List<Person> findPersons();

    @Query(value = "UPDATE personas SET clicks = :clicks WHERE cedula=:card and tipo=:type", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    void addClicks(@Param("card") int card, @Param("type") String type, @Param("clicks") int clicks);

    @Query(value = "SELECT clicks FROM personas WHERE cedula=:card and tipo=:type", nativeQuery = true)
    int getClicks(@Param("card") int card, @Param("type") String type);

    
	@Query(value = "SELECT *.pr FROM personas pr join planetas pl on pr.plante_id=pl.id where pl.id=:id", nativeQuery = true)
	List<Person> findPlanetPersons(@Param("id") String id);

}