package com.ivansoft.java.exercises.designpatterns.buildercomplexobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Computer {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;
}
