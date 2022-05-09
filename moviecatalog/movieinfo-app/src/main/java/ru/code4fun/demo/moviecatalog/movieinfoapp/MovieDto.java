package ru.code4fun.demo.moviecatalog.movieinfoapp;

import java.time.LocalDate;

public class MovieDto {
    private String title;
    private String genre;
    private LocalDate releasedAt;

    public MovieDto(String title, String description, LocalDate releasedAt) {
        this.title = title;
        this.genre = description;
        this.releasedAt = releasedAt;
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
