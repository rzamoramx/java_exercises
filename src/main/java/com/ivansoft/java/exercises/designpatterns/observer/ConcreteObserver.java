package com.ivansoft.java.exercises.designpatterns.observer;

public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        // logic here
        System.out.println(name + " received message: " + message);
    }
}
