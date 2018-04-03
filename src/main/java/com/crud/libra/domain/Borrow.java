package com.crud.libra.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;



@Entity(name = "borrows")
public class Borrow {
    private Long idBorrow;
    private Date borrowDate;
    private Date returnDate;
    private Reader reader;
    private Book book;

    public Borrow() {
    }

    public Borrow(Long idBorrow, Date borrowDate, Date returnDate, Reader reader, Book book) {
        this.idBorrow = idBorrow;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.book = book;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_borrow", unique = true)
    @NotNull
    public Long getIdBorrow() {
        return idBorrow;
    }

    @Column(name = "borrow_date")
    @NotNull
    public Date getBorrowDate() {
        return borrowDate;
    }

    @Column (name = "return_date")
    public Date getReturnDate() {
        return returnDate;
    }

    @ManyToOne
    @JoinColumn (name = "id_reader")
    public Reader getReader() {
        return reader;
    }

    @ManyToOne
    @JoinColumn (name = "id_book")
    public Book getBook() {
        return book;
    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
