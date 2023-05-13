package com.cst438_library.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookId;

    private String title;

    private String author;

    @ManyToOne
    @JoinColumn(name="patronId")
    private Patron checkoutPatronId;
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

    public Patron getCheckoutPatronId() {
        return checkoutPatronId;
    }

    public void setCheckoutPatronId(Patron checkoutPatronId) {
        this.checkoutPatronId = checkoutPatronId;
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
