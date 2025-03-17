package edu.miu.cs.cs425.sahid.component;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayFlattenerTest {

    private final ArrayFlattener arrayFlattener = new ArrayFlattener();

    @Test
    public void testFlattenArray_ValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};

        int[] actualOutput = arrayFlattener.flattenArray(input);

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFlattenArray_NullInput() {
        int[] actualOutput = arrayFlattener.flattenArray(null);
        assertNull(actualOutput);
    }
}
