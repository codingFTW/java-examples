package com.athingforcode.examples;

import java.util.Map;

import static java.util.Map.entry;

public class E09_MapGetDefault {
    public static void main(String[] args) {

        Map<String, Integer> priceMap = Map.ofEntries(
                entry("banana",2000),
                entry("egg",500),
                entry("sirloin",120000)
        );

        // chicken price is null because key "chicken" is not found within map
        if (priceMap.get("chicken") == null) System.out.println("chicken price is null");

        // set default price as -99 if price is not found
        int price = priceMap.getOrDefault("chicken",-99);
        if(price == -99) System.out.println("chicken doesn't have price yet");

    }
}
