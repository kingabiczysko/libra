package com.crud.libra.domain;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
    private Long idBook;
    private String status;
    private Title title;
    private List<Borrow> borrowList = new ArrayList<>();

    public BookDto() {
    }

    public BookDto(Long idBook, String status
            , Title title
                   ) {
        this.idBook = idBook;
        this.status = status;
        this.title = title;

    }


    public Long getIdBook() {
        return idBook;
    }

    public String getStatus() {
        return status;
    }

    public Title getTitle() {
        return title;
    }

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
