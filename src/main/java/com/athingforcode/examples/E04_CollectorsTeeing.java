package com.athingforcode.examples;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class E04_CollectorsTeeing {
    public static void main(String[] args) {
        // List of Student Result
        List<StudentResult> numbers = Arrays.asList(
                new StudentResult("1", 100,80),
                new StudentResult("2",95, 90),
                new StudentResult("3", 95,82)
        );

        var result = numbers.stream()
                .collect(
                        //Collectors.teeing is used to perform two independent reductions on the same input elements, on the single pass stream operation
                        // and merge their results.
                        Collectors.teeing(
                                // First collector: summarize math scores
                                Collectors.summarizingDouble(StudentResult::mathScore),
                                // Second collector: summarize English scores
                                Collectors.summarizingDouble(StudentResult::englishScore),
                                // Merger function: combine results into ClassStatistics
                                (mathStats, englishStats) -> new ClassStatistics(mathStats, englishStats)
                        )
                );

        // Print the results
        System.out.println("Class statistics for math :  " + result.mathStats());
        System.out.println("Class statistics for math :  " + result.englishStats());
    }
}
record ClassStatistics(DoubleSummaryStatistics mathStats, DoubleSummaryStatistics englishStats){}
record StudentResult(String id, double mathScore, double englishScore){}
