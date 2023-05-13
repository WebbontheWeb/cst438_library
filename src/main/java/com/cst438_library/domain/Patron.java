package com.cst438_library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Patron {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int patronId;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy="checkoutPatron")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

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
