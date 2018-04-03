package com.crud.libra.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "books")
public class Book {
    private Long idBook;
    private String status;
    private Title title;
    private List<Borrow> borrowList = new ArrayList<>();

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

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_title")
    public Title getTitle() {
        return title;
    }

    @OneToMany(
            targetEntity = Borrow.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Borrow> getBorrowList() {
        return borrowList;
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

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }
}
