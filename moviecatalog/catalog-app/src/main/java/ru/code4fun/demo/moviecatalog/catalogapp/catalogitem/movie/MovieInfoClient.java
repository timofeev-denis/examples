package ru.code4fun.demo.moviecatalog.catalogapp.catalogitem.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "movieinfo", url = "localhost:9010/movies")
public interface MovieInfoClient {

    @GetMapping("")
    List<MovieDto> findAll();

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable Long id);
}
