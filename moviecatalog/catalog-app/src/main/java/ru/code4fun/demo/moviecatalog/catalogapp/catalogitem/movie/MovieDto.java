package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.movie;

import java.time.LocalDate;

public class MovieDto {
    private Long id;
    private String title;
    private String genre;
    private LocalDate releasedAt;

    public MovieDto(Long id, String title, String description, LocalDate releasedAt) {
        this.id = id;
        this.title = title;
        this.genre = description;
        this.releasedAt = releasedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDate releasedAt) {
        this.releasedAt = releasedAt;
    }
}
