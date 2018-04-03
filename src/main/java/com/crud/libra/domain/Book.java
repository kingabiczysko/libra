package com.crud.libra.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity (name = "books")
public class Book {
    private Long idBook;
    private String status;
    private Title title;

    public Book() {
    }

    public Book(Long idBook, String status, Title title) {
        this.idBook = idBook;
        this.status = status;
        this.title = title;
    }


    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "id_book", unique = true)
    public Long getIdBook() {
        return idBook;
    }

    @NotNull
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "id_title")
    @NotNull
    public Title getTitle() {
        return title;
    }


    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

}
