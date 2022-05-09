package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.rating;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "rating", url = "localhost:9020/ratings")
public interface RatingClient {

    @GetMapping("")
    List<RatingDto> findAll();

    @GetMapping("/{id}")
    RatingDto findById(@PathVariable Long id);
}
