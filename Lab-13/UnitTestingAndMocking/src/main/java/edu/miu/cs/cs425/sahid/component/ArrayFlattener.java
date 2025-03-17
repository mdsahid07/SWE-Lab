package edu.miu.cs.cs425.sahid.component;

import edu.miu.cs.cs425.sahid.service.ArrayFlattenerService;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener implements ArrayFlattenerService {
    @Override
    public int[] flattenArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        List<Integer> flatList = new ArrayList<>();
        for (int[] subArray : nestedArray) {
            for (int num : subArray) {
                flatList.add(num);
            }
        }

        return flatList.stream().mapToInt(i -> i).toArray();
    }
}