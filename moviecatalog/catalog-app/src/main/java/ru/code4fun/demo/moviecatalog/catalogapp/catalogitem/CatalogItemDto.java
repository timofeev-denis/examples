package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem;

import java.time.LocalDate;

class CatalogItemDto {
    private Long id;
    private String title;
    private String genre;
    private LocalDate releasedAt;
    private Float rating;

    public CatalogItemDto(Long id, String title, String genre, LocalDate releasedAt, Float rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releasedAt = releasedAt;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleasedAt() {
        return releasedAt;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
