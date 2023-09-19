package com.ivansoft.java.exercises.designpatterns.buildercomplexobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuilderComplexObjectsTest {
    /**
     * The Builder Pattern is a creational design pattern that lets you construct complex objects step by step. The
     * pattern allows you to produce different types and representations of an object using the same construction code.
     *
     * check the implementation code is located at /designpatterns/buildercomplexobjects package
     */

    @Test
    public void testGamingComputerWithOutBuilderHelper() {
        ComputerBuilder builder = new GamingComputerBuilder();
        Computer computer = builder
                .setCpu("Intel i7")
                .setGpu("Nvidia RTX 2080")
                .setRam(16)
                .setStorage(512)
                .build();
        System.out.println(computer);
        assertEquals("Intel i7", computer.getCpu());
        assertEquals("Nvidia RTX 2080", computer.getGpu());
    }

    @Test
    public void testGamingComputerWithBuilderHelper() {
        ComputerDirector director = new ComputerDirector();
        Computer computer = director.buildGamingComputer();
        System.out.println(computer);
        assertEquals("Intel i7", computer.getCpu());
        assertEquals("Nvidia RTX 2080", computer.getGpu());
    }

    @Test
    public void testOfficeComputerWithHelperBuilder() {
        ComputerDirector director = new ComputerDirector();
        Computer computer = director.buildOfficeComputer();
        System.out.println(computer);
        assertEquals("Intel i5", computer.getCpu());
        assertNull(computer.getGpu());
    }
}
