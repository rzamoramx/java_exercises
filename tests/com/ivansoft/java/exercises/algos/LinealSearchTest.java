package com.ivansoft.java.exercises.algos;

import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

class LinealSearchTest {
    @Mock
    LinealSearch linealSearch;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void search() {
        when(linealSearch.search(new int[]{1, 2, 3, 4, 5}, 4)).thenReturn(3);
        assertEquals(3, linealSearch.search(new int[]{1, 2, 3, 4, 5}, 4));
    }
}