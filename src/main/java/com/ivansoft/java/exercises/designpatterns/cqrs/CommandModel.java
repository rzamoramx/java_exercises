package com.ivansoft.java.exercises.designpatterns.cqrs;

public interface CommandModel {
    void submitCommand(Command command);
}
