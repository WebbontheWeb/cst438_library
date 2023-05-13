package com.cst438_library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patron {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int patronId;

    private String name;

    //getters and setters
    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //constructor
    public Patron(int patronId, String name){
        this.patronId = patronId;
        this.name = name;
    }

    public Patron() {

    }

    @Override
    public String toString() {
        return "ID: " + patronId;
    }

}
