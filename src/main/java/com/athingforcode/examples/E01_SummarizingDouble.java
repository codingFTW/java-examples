package com.athingforcode.examples;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class E01_SummarizingDouble {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Phone", 599.99),
                new Product("Tablet", 299.99),
                new Product("Smartwatch", 199.99),
                new Product("Headphones", 149.99)
        );

        /*
        Collectors.summarizingDouble() is a static method in Java's Collectors class that returns a Collector capable of computing summary statistics for double-valued functions of input elements.
        It's commonly used in conjunction with the stream() method to gather statistical information about numeric properties of objects in a collection.
        The Collector produced by summarizingDouble() accumulates input elements into a DoubleSummaryStatistics instance.
        This method is particularly useful when we need to compute multiple statistics (like count, sum, min, max, and average) in a single pass over the data.
         */

        // Use Collectors.summarizingDouble() to get statistics
        DoubleSummaryStatistics priceStats = products.stream()
                .collect(Collectors.summarizingDouble(Product::price));

        //The result of collect(Collectors.summarizingDouble()) is a DoubleSummaryStatistics object, which provides methods to access the computed statistics.
        // Print the statistics
        System.out.println("Product Price Statistics:");
        System.out.println("Count: " + priceStats.getCount());
        System.out.println("Sum: $" + String.format("%.2f", priceStats.getSum()));
        System.out.println("Min: $" + String.format("%.2f", priceStats.getMin()));
        System.out.println("Max: $" + String.format("%.2f", priceStats.getMax()));
        System.out.println("Average: $" + String.format("%.2f", priceStats.getAverage()));

    }
}

record Product(String name, double price) {}