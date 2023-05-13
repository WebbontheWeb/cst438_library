package com.cst438_library.controller;

import com.cst438_library.domain.Book;
import com.cst438_library.domain.BookRepository;
import com.cst438_library.domain.Patron;
import com.cst438_library.domain.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    PatronRepository patronRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/patron/{patronId}")
    public Patron getPatron(@PathVariable int patronId){

        //System.out.println("PatronId: " + patronId);

        Patron patron = patronRepository.findById(patronId).orElse(null);

        if(patron == null){
            System.out.println("Not Found");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "No Patron matching that Id. " );
        }

        //System.out.println(patron);

        return patron;
    }

    @PutMapping("/book/{bookId}/checkout/{patronId}")
    public Book checkoutBook(@PathVariable int bookId, @PathVariable int patronId){
        Book book = bookRepository.findById(bookId).orElse(null);

        if(book == null){
            System.out.println("Not Found");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "No Book matching that Id. " );
        }

        Patron patron = patronRepository.findById(patronId).orElse(null);

        if(patron == null){
            System.out.println("Not Found");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "No Patron matching that Id. " );
        }

        book.setCheckoutPatronId(patron);
        book.setCheckoutDate(new Date(System.currentTimeMillis()));

        return bookRepository.save(book);
    }

    @PutMapping("/book/{bookId}/return")
    public Book returnBook(@PathVariable int bookId){
        Book book = bookRepository.findById(bookId).orElse(null);

        if(book == null){
            System.out.println("Not Found");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "No Book matching that Id." );
        }

        if(book.getCheckoutPatronId() == null){
            System.out.println("Not Found");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Book is not checked out." );
        }

        book.setCheckoutPatronId(null);
        book.setCheckoutDate(null);

        return bookRepository.save(book);
    }
}
