package ru.code4fun.demo.moviecatalog.rating;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final List<RatingDto> rating = List.of(
            new RatingDto(1L, 7.6f),
            new RatingDto(2L, 9.0f),
            new RatingDto(3L, 8.9f),
            new RatingDto(4L, 8.9f),
            new RatingDto(5L, 9.2f));

    @GetMapping("")
    public List<RatingDto> findAll() {
        return this.rating;
    }

    @GetMapping("/{moveId}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable Long moveId) {
        return ResponseEntity.of(this.rating.stream()
                .filter(r -> r.getMovieId().equals(moveId))
                .findFirst());
    }
}
