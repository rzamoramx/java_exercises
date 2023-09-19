package com.ivansoft.java.exercises.designpatterns.buildercomplexobjects;

public interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setRam(int ram);
    ComputerBuilder setStorage(int storage);
    Computer build();
}
