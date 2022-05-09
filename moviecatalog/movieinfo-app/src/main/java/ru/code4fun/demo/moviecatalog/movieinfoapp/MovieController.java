package ru.code4fun.demo.moviecatalog.movieinfoapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private List<MovieDto> movies = List.of(
            new MovieDto(1L, "The Terminator", "Action", LocalDate.of(1984, 10, 26)),
            new MovieDto(2L, "The Dark Knight", "Action", LocalDate.of(2008, 7, 14)),
            new MovieDto(3L, "The Lord of the Rings: The Return of the King", "Adventure", LocalDate.of(2003, 12, 1)),
            new MovieDto(4L, "Pulp Fiction", "Crime", LocalDate.of(1994, 5, 21)),
            new MovieDto(5L, "The Godfather", "Drama", LocalDate.of(1972, 3, 14)));

    @GetMapping("")
    public List<MovieDto> findAll() {
        return this.movies;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst());
    }
}
