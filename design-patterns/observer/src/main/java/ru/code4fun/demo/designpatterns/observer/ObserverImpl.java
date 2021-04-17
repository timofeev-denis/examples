package ru.code4fun.demo.designpatterns.observer;

public class ObserverImpl implements Observer {

    private final String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + ": I was updated");
    }
}
