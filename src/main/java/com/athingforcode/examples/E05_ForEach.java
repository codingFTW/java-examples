package com.athingforcode.examples;

import java.util.List;

public class E05_ForEach {
    public static void main(String[] args) {
        var list = List.of("james","gosling","brian","goetz");

        // Java 5
        for(String name : list) {
            System.out.println(name);
        }

        //JDK 8+
        list.forEach(System.out::println);
    }
}
