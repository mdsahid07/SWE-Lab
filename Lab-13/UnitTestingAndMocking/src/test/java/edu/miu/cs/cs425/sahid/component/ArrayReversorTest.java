package edu.miu.cs.cs425.sahid.component;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import edu.miu.cs.cs425.sahid.service.ArrayFlattenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArrayReversorTest {
    private ArrayReversor arrayReversor;
    private ArrayFlattenerService mockArrayFlattenerService;

    @BeforeEach
    public void setUp() {
        mockArrayFlattenerService = Mockito.mock(ArrayFlattenerService.class);
        arrayReversor = new ArrayReversor(mockArrayFlattenerService);
    }

    @Test
    public void testReverseArray_ValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = {1, 3, 0, 4, 5, 9};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};

        when(mockArrayFlattenerService.flattenArray(input)).thenReturn(flattenedArray);

        int[] actualOutput = arrayReversor.reverseArray(input);

        assertArrayEquals(expectedOutput, actualOutput);
        verify(mockArrayFlattenerService, times(1)).flattenArray(input);
    }

    @Test
    public void testReverseArray_NullInput() {
        when(mockArrayFlattenerService.flattenArray(null)).thenReturn(null);

        int[] actualOutput = arrayReversor.reverseArray(null);

        assertNull(actualOutput);
        verify(mockArrayFlattenerService, times(1)).flattenArray(null);
    }
}

