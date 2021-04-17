package ru.code4fun.demo.designpatterns.observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class SubjectTest {

    @Test
    void observableWithoutSubscribers() {
        ObservableImpl observable = new ObservableImpl();

        observable.doStuff();
    }

    @Test
    void observableNotifiesAllSubscribers() {
        ObservableImpl observable = new ObservableImpl();
        List<Observer> observers = addSubscribers(observable, 5);

        observable.doStuff();

        observers.forEach(o -> verify(o).update());
    }

    @Test
    void observableDoesNotNotifiesUnsubscribed() {
        ObservableImpl observable = new ObservableImpl();
        List<Observer> observers = addSubscribers(observable, 5);
        Observer unsubscribed = observers.get(2);
        observable.unsubscribe(unsubscribed);

        observable.doStuff();

        verify(unsubscribed, times(0)).update();
    }

    @Test
    void UnsubscribeDoesNotAffectOthers() {
        ObservableImpl observable = new ObservableImpl();
        List<Observer> observers = addSubscribers(observable, 5);
        Observer unsubscribed = observers.get(2);
        observable.unsubscribe(unsubscribed);

        observable.doStuff();

        observers.stream()
                .filter(o -> !o.equals(unsubscribed))
                .forEach(o -> verify(o).update());
    }

    private List<Observer> addSubscribers(ObservableImpl observable, Integer subscribersCount) {
        List<Observer> observers = new ArrayList<>(subscribersCount);
        for (int i = 0; i < subscribersCount; i++) {
            Observer observer = mock(Observer.class);
            observers.add(observer);
            observable.subscribe(observer);
        }
        return observers;
    }
}