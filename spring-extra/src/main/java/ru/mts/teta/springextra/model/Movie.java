package ru.mts.teta.springextra.model;

import java.time.LocalDateTime;

public class Movie {
    private LocalDateTime releaseDate;
    private String title;
    private String genre;

    public Movie(LocalDateTime releaseDate, String title, String genre) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.genre = genre;
    }
}
