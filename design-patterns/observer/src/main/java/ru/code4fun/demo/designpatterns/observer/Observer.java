package ru.code4fun.demo.designpatterns.observer;

public class Observer {

    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(name + ": I was updated");
    }
}
