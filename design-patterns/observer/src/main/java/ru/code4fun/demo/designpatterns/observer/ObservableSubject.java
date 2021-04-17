package ru.code4fun.demo.designpatterns.observer;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableSubject {

    private Collection<Observer> subscribers = new ArrayList<>();

    public void doStuff() {
        // Doing some stuff...
        notifySubscribers();
    }

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    private void notifySubscribers() {
        subscribers.forEach(Observer::update);
    }
}
