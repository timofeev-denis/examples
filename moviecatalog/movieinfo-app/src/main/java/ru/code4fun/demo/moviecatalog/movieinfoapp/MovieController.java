package ru.code4fun.demo.moviecatalog.movieinfoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("")
    public List<MovieDto> findAll() {
        return List.of(
                new MovieDto("The Terminator", "Action", LocalDate.of(1984, 10, 26)),
                new MovieDto("The Dark Knight", "Action", LocalDate.of(2008, 7, 14)),
                new MovieDto("The Lord of the Rings: The Return of the King", "Adventure", LocalDate.of(2003, 12, 1)),
                new MovieDto("Pulp Fiction", "Crime", LocalDate.of(1994, 5, 21)),
                new MovieDto("The Godfather", "Drama", LocalDate.of(1972, 3, 14)));
    }

}
