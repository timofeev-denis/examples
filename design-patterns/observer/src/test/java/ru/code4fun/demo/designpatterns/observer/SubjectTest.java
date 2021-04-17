package ru.code4fun.demo.designpatterns.observer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SubjectTest {

    private static final PrintStream originalOut = System.out;
    private static final OutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    static void beforeAll() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void afterAll() {
        System.setOut(originalOut);
    }

    @Test
    void observableNotifiesAllSubscribers() {
        Observer observerMock1 = mock(Observer.class);
        Observer observerMock2 = mock(Observer.class);
        Observer observerMock3 = mock(Observer.class);
        ObservableSubject subject = new ObservableSubject();
        subject.subscribe(observerMock1);
        subject.subscribe(observerMock2);
        subject.subscribe(observerMock3);

        subject.doStuff();

        verify(observerMock1).update();
        verify(observerMock2).update();
        verify(observerMock3).update();
    }
}