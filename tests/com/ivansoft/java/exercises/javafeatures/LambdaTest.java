package com.ivansoft.java.exercises.javafeatures;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    @Test
    void testImplementGreeting() {
        var name = "John";
        var expected = "Hello " + name;

        var result = Lambda.implementGreeting(name);
        assert result.equals(expected);
    }
    
    @Test
    void testAlphabeticalOrderNames() {
        List<String> names = new ArrayList<>();
        names.add("Juan");
        names.add("María");
        names.add("Pedro");
        names.add("Ana");
        
        List<String> expected = new ArrayList<>();
        expected.add("Ana");
        expected.add("Juan");
        expected.add("María");
        expected.add("Pedro");
        
        var result = Lambda.alphabeticalOrderNames(names);
        assert result.equals(expected);
    }

    @Test
    void testImplementSum() {
        var expected = 8;
        var v1 = 2;
        var v2 = 6;

        var result = Lambda.implementSum(v1, v2);
        assert result == expected;
    }
}
