package ru.code4fun.demo.designpatterns.observer;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableImpl implements Observable {

    private Collection<Observer> subscribers = new ArrayList<>();

    public void doStuff() {
        // Doing some stuff...
        notifySubscribers();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    private void notifySubscribers() {
        subscribers.forEach(Observer::update);
    }
}
