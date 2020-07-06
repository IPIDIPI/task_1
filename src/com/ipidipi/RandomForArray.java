package com.ipidipi;

import java.util.Arrays;

public class RandomForArray {

    private int values[];
    private int weights[];
    private int ranges[];
    private int sum;

    public RandomForArray(int values[], int weights[]) {
        this.values = values;
        this.weights = weights;
        ranges = new int[values.length];
        sum = 0;
        for (int weight: weights) {
            sum += weight;
        }
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i ++) {
            ranges[i] = lastSum;
            lastSum += weights[i];
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * (sum - 1));

        int index = Arrays.binarySearch(ranges, random);
        return values[index >= 0 ? index : -index - 2];
    }
}
