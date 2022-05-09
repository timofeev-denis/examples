package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.rating;

public class RatingDto {
    private Long movieId;
    private Float rating;

    public RatingDto(Long movieId, Float rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
