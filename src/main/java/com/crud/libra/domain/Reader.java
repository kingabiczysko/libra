package com.crud.libra.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "readers")
public class Reader {
    private Long idReader;
    private String name;
    private String surname;
    private Date created;

    public Reader() {
    }

    public Reader(Long idReader, String name, String surname) {
        this.idReader = idReader;
        this.name = name;
        this.surname = surname;
        this.created = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reader", unique = true)
    public Long getIdReader() {
        return idReader;
    }

    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    @NotNull
    public String getSurname() {
        return surname;
    }

    @Column(name = "created")
    @NotNull
    public Date getCreated() {
        return created;
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


}
