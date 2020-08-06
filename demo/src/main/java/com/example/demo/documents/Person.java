package com.example.demo.documents;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.documents.utils.PersonId;

@Entity
@Table(name = "personas")
public class Person {

    @EmbeddedId
    PersonId personId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "genero")
    private String gender;

    @Column(name = "edad")
    private int age;

    @Column(name = "altura")
    private String height;

    @Column(name = "peso")
    private String weight;

    @Column(name = "fecha_nacimiento")
    private String dateBirth;

    @Column(name = "clicks")
    private int cantidad;

    @Column(name = "planeta_id")
    private String planetId;

    public Person() {
    }

    public Person(PersonId personId, String name, String gender, int age, String height, String weight,
            String dateBirth, int cantidad, String planetId) {
        this.personId = personId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.dateBirth = dateBirth;
        this.cantidad = cantidad;
        this.planetId = planetId;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }
}
