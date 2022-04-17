package ru.code4fun.demo.apigateway.backend.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(List.of(
                new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954),
                new Book("Don Quixote", "Miguel de Cervantes", 1605),
                new Book("The Little Prince", "Antoine de Saint-Exupery", 1943)));
    }
}
