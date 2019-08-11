package ru.code4fun.examples.configserver;

/**
 * Created by: Denis Timofeev
 * Date: 24.07.2019
 */

public class CarDto {
    private String brand;
    private String model;

    CarDto(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
