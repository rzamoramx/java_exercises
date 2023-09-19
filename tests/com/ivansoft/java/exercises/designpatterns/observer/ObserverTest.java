package com.ivansoft.java.exercises.designpatterns.observer;

import org.junit.jupiter.api.Test;

public class ObserverTest {
    /**
     * The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects so
     * that when one object changes state, all its dependents (observers) are notified and updated automatically. This
     * pattern is used to maintain consistency between related objects without making them tightly coupled
     *
     * check the implementation code is located at /designpatterns/observer package
     */
    @Test
    public void testObserver() {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver obs1 = new ConcreteObserver("Observer one");
        ConcreteObserver obs2 = new ConcreteObserver("Observer two");

        subject.addObserver(obs1);
        subject.addObserver(obs2);

        subject.setMessage("Hi world from Observer pattern");
    }
}
