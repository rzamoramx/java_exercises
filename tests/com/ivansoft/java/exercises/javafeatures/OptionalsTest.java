package com.ivansoft.java.exercises.javafeatures;

import org.junit.jupiter.api.Test;

public class OptionalsTest {
    @Test
    void testPerformOptionals() {
        Optionals.performOptionals();
    }

    @Test
    void testGetOptionalValueNonEmpty() {
        var value = 1;
        var expected = "Hi!";

        var result = Optionals.getOptionalValue(value);
        assert result.isPresent();
        assert result.get().equals(expected);
    }

    @Test
    void testGetOptionalValueEmpty() {
        var value = 2;

        var result = Optionals.getOptionalValue(value);
        assert result.isEmpty();
    }
}
