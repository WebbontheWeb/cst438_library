package com.cst438_library.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookId;

    private String title;

    private String author;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="patronId")
    private Patron checkoutPatron;

    private Date checkoutDate;

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Patron getCheckoutPatron() {
        return checkoutPatron;
    }

    public void setCheckoutPatron(Patron checkoutPatronId) {
        this.checkoutPatron = checkoutPatronId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

//    @Override
//    public String toString() {
//        return "";
//    }

}
