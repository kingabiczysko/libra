package com.crud.libra.domain;

public class TitleDto {

    private Long idTitle;
    private String title;
    private String author;
    private int publishedYear;

    public TitleDto() {
    }

    public TitleDto(Long idTitle, String title, String author, int publishedYear) {
        this.idTitle = idTitle;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public Long getIdTitle() {
        return idTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
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

}
