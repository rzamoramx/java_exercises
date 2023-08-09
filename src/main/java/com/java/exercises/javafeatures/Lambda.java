package com.java.exercises.javafeatures;

import java.util.List;

public class Lambda {
    @FunctionalInterface
    interface Greeting {
        String greet(String name);
    }

    @FunctionalInterface
    interface Sum {
        int calc(int a, int b);
    }

    static String implementGreeting(String name) {
        /*Greeting greeting = (n) -> {
            System.out.println("Print inside lambda function: Hello " + name + "!");
            return "Hello " + name;
        };*/
        Greeting greeting = (n) -> "Hello " + n;
        return greeting.greet(name);
    }

    static List<String> alphabeticalOrderNames(List<String> names) {
        // Order names in alphabetical order

        // can be implemented as method reference, names.sort(String::compareTo)
        names.sort((s1, s2) -> s1.compareTo(s2));
        return names;
    }

    static int implementSum(int a1, int a2) {
        Sum sum = (a, b) -> a + b; // can be implemented as method reference, Operation sum = Integer::sum;

        return sum.calc(a1, a2);
    }
}
