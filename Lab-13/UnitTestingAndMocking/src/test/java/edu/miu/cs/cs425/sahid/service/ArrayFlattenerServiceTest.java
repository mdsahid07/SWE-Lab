package edu.miu.cs.cs425.sahid.service;


import static org.junit.jupiter.api.Assertions.*;

import edu.miu.cs.cs425.sahid.component.ArrayFlattener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerServiceTest {

    private ArrayFlattenerService arrayFlattenerService;

    @BeforeEach
    public void setUp() {
        // Directly using the actual implementation for testing
        arrayFlattenerService = new ArrayFlattener();
    }

    @Test
    public void testFlattenArray_ValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};

        int[] actualOutput = arrayFlattenerService.flattenArray(input);

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFlattenArray_NullInput() {
        int[] actualOutput = arrayFlattenerService.flattenArray(null);

        assertNull(actualOutput);
    }
}
