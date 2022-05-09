package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.movie.MovieDto;
import ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.movie.MovieInfoClient;
import ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.rating.RatingClient;
import ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.rating.RatingDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/catalog")
public class CatalogItemController {

    private final MovieInfoClient movieInfoClient;
    private final RatingClient ratingClient;

    public CatalogItemController(MovieInfoClient movieInfoClient, RatingClient ratingClient) {
        this.movieInfoClient = movieInfoClient;
        this.ratingClient = ratingClient;
    }

    @GetMapping("")
    public ResponseEntity<List<CatalogItemDto>> findAll() {
        List<CatalogItemDto> movies = movieInfoClient.findAll()
                .stream()
                .map(this::toFullInfoDto)
                .peek(this::enrichWithRating)
                .collect(toList());
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogItemDto> findById(@PathVariable Long id) {
        MovieDto movieInfo = movieInfoClient.findById(id);
        CatalogItemDto fullInfo = toFullInfoDto(movieInfo);
        enrichWithRating(fullInfo);
        return ResponseEntity.ok(fullInfo);
    }

    private void enrichWithRating(CatalogItemDto catalogItemDto) {
        RatingDto rating = ratingClient.findById(catalogItemDto.getId());
        catalogItemDto.setRating(rating.getRating());
    }

    private CatalogItemDto toFullInfoDto(MovieDto movieDto) {
        return new CatalogItemDto(movieDto.getId(),
                movieDto.getTitle(),
                movieDto.getGenre(),
                movieDto.getReleasedAt(),
                null);
    }
}
