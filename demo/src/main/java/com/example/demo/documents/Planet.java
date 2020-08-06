package com.example.demo.documents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "planetas")
public class Planet {
    @Id
    @GeneratedValue(generator = "prod-generator-planet")
    @GenericGenerator(name = "prod-generator-planet", parameters = @Parameter(name = "prefix", value = "PL"), strategy = "com.example.demo.documents.StringGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String  name;

    @Column(name = "periodo")
    private String  rotationPeriod;

    @Column(name = "diametro")
    private String  diameter;

    @Column(name = "clima")
    private String climate;

    @Column(name = "terreno")
    private String  field;

    @Column(name = "clicks")
    private int cantidad;

    @Column(name = "habitantes")
    private int inhabitants;

    public Planet() {
    }

    public Planet(String id, String name, String rotationPeriod, String diameter, String climate, String field,
            int cantidad, int inhabitants) {
        this.id = id;
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.field = field;
        this.cantidad = cantidad;
        this.inhabitants = inhabitants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

}
