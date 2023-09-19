package com.ivansoft.java.exercises.javafeatures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    static List<String> concatLists(List<String> l1, List<String> l2) {
        List<String> lista1 = Arrays.asList("Hola", "Mundo");
        List<String> lista2 = Arrays.asList("¡Bienvenidos", "a", "Stream!");

        return Stream.concat(lista1.stream(), lista2.stream())
                .collect(Collectors.toList());
    }

    static List<String> mappingUpperCase(List<String> names) {
        return names.stream()
                .map(name -> name.toUpperCase()) // can be implemented as method reference, String::toUpperCase
                .collect(Collectors.toList());
    }

    static List<String> sortAlphabetically(List<String> names) {
        return names.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    static int reductionSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (a, b) -> a + b);
    }

    static void iterToReplaceChar(List<String> names) {
        names.stream()
                .forEach(name -> {
                    var x = name.replace("a", "_");
                    System.out.println(x);
                });
    }
}
