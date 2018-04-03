package com.crud.libra.domain;

import java.util.Date;
import java.util.List;

public class ReaderDto {
    private Long idReader;
    private String name;
    private String surname;
    private Date created;
    private List<BorrowDto> borrowList;

    public ReaderDto() {
    }

    public ReaderDto(Long idReader, String name, String surname) {
        this.idReader = idReader;
        this.name = name;
        this.surname = surname;
        this.created = new Date();
    }

    public Long getIdReader() {
        return idReader;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getCreated() {
        return created;
    }

    public List<BorrowDto> getBorrowList() {
        return borrowList;
    }

    public void setIdReader(Long idReader) {
        this.idReader = idReader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setBorrowList(List<BorrowDto> borrowList) {
        this.borrowList = borrowList;
    }
}
