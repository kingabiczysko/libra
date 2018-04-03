package com.crud.libra.domain;

import java.util.Date;

public class BorrowDto {
    private Long idBorrow;
    private Date borrowDate;
    private Date returnDate;
    private Reader reader;
    private Book book;

    public BorrowDto() {
    }

    public BorrowDto(Long idBorrow, Date borrowDate, Date returnDate, Reader reader, Book book) {
        this.idBorrow = idBorrow;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.book = book;
    }

    public Long getIdBorrow() {
        return idBorrow;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Reader getReader() {
        return reader;
    }

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
