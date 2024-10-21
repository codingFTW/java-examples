package com.athingforcode.examples;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.Map.entry;

public class E08_SetListMapFactory {
    public static void main(String[] args) {
        //List factory method
        List<String> students = List.of("tono","adi","joko","bodo");
        List<Lesson> lessons = List.of(
            new Lesson("1","Math"),
            new Lesson("2","English"),
            new Lesson("3","Physics")
        );
        System.out.println(students);
        System.out.println(lessons);

        //Set factory method
        Set<String> studentSet = Set.of("tono","adi","joko","bodo");
        Set<Lesson> lessonSet = Set.of(
                new Lesson("1","Math"),
                new Lesson("2","English"),
                new Lesson("3","Physics")
        );
        System.out.println(studentSet);
        System.out.println(lessonSet);

        Map<String, Integer> priceMap = Map.ofEntries(
                entry("banana",2000),
                entry("egg",500),
                entry("sirloin",120000)
        );
        System.out.println(priceMap);

    }
}

record Lesson(String id, String name) {}