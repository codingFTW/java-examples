package com.athingforcode.examples;

import java.util.List;
import java.util.stream.Collectors;

public class E010_StringJoining {
    public static void main(String[] args) {
        List<String> menu = List.of("Rendang","Fried Rice","Sate","Soto","Tempe","Ayam Geprek");
        //concat string using String.join
        String shortMenu = String.join(", ", menu);
        //Concat string using collector from Stream of string
        String conciseMenu = menu.stream().collect(Collectors.joining(", "));

        //Both prints Rendang, Fried Rice, Sate, Soto, Tempe, Ayam Geprek
        System.out.println(shortMenu);
        System.out.println(conciseMenu);
    }
}
