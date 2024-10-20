package com.athingforcode.examples;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class E00_DoubleSummaryStatistics {
    public static void main(String[] args) {
        // Create an array of doubles
        double[] numbers = {1.5, 2.3, 3.7, 4.1, 5.8};

        /*
        - DoubleSummaryStatistics is a Java class that provides a way to collect statistics on a stream of double values.
        - It allows us to calculate common statistical measures like count, sum, minimum, maximum, and average in a single pass over the data.
        - DoubleSummaryStatistics is particularly useful when working with large datasets, as it eliminates the need for multiple iterations to compute different statistics.
        - The class provides methods like getCount(), getSum(), getMin(), getMax(), and getAverage() to retrieve the computed statistics.
         */
        // Create a DoubleSummaryStatistics object
        DoubleSummaryStatistics stats = Arrays.stream(numbers)
                .summaryStatistics();

        // Print the statistics
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}
