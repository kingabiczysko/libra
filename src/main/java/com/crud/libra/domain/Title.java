package com.crud.libra.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "titles")
public class Title {
    private Long idTitle;
    private String title;
    private String author;
    private int publishedYear;
    private List<Book> books = new ArrayList<>();

    public Title() {
    }

    public Title(Long idTitle, String title, String author, int publishedYear) {
        this.idTitle = idTitle;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_title", unique = true)
    public Long getIdTitle() {
        return idTitle;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    @Column(name="published_year")
    public int getPublishedYear() {
        return publishedYear;
    }

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Book> getBooks(){
        return books;
    }

    public void setIdTitle(Long idTitle) {
        this.idTitle = idTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;

    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
