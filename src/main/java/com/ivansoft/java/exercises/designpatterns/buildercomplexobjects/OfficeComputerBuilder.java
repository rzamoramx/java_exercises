package com.ivansoft.java.exercises.designpatterns.buildercomplexobjects;

public class OfficeComputerBuilder implements ComputerBuilder {
    private String cpu;
    private String gpu;
    private int ram;
    private int storage;


    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        System.out.println("Office computers don't have dedicated GPUs");
        return null;
    }

    @Override
    public ComputerBuilder setRam(int ram) {
        if (ram > 8) {
            throw new IllegalArgumentException("Office computers don't need more than 8GB of RAM");
        }
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(cpu, gpu, ram, storage);
    }
}
