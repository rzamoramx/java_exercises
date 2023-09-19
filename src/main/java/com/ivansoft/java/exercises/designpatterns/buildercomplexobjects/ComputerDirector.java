package com.ivansoft.java.exercises.designpatterns.buildercomplexobjects;

public class ComputerDirector {
    public Computer buildGamingComputer() {
        return new GamingComputerBuilder()
                .setCpu("Intel i7")
                .setGpu("Nvidia RTX 2080")
                .setRam(16)
                .setStorage(512)
                .build();
    }

    public Computer buildOfficeComputer() {
        return new OfficeComputerBuilder()
                .setCpu("Intel i5")
                .setRam(8)
                .setStorage(256)
                .build();
    }
}
