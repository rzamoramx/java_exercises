package com.ivansoft.java.exercises.compiling;

public class File2 {
    public static void main(String[] args) throws Exception {
        printMessage2();
    }

    public static void printMessage2() throws Exception {
        System.out.println("Hello from file2.java");
        throw new Exception("Un error");
    }
}
