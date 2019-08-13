package ru.code4fun.demo.cars;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by: Denis Timofeev
 * Date: 24.07.2019
 */

@RefreshScope
@RestController
@RequestMapping("/")
public class CarsController {

    @Value("${cars.limit}")
    private Integer limit;

    /**
     * Returns a list of cars. List size is limited to the value of <b>cars.limit</b> property.
     *
     * @return A list of cars
     */
    @GetMapping
    public ResponseEntity<List> getCars() {
        List<CarDto> cars = Arrays.asList(
                new CarDto("Ford", "Mustang"),
                new CarDto("Ford", "F-1"),
                new CarDto("Chevrolet", "Camaro"),
                new CarDto("BMW", "X5"));
        return ok(cars.stream()
                .limit(limit)
                .collect(toList()));
    }
}
