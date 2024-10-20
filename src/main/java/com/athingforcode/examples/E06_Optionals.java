package com.athingforcode.examples;

import java.util.Optional;

public class E06_Optionals {
    public static void main(String[] args) {
        // Instead of:
        String firstName = null;

        // Use:
        Optional<String> middleName = Optional.empty();

        // Or if we have a value:
        Optional<String> name = Optional.of("Lisa");

        // get value contained in optional, provide default value if value is null
        System.out.println(name.orElse("default name"));
        // or we can pass lambda that returns value
        System.out.println(middleName.orElseGet(() -> "defaultValue"));
        // or throw exception if value is null
        System.out.println(name.orElseThrow());
        // Perform action only if value is present
        name.ifPresent((x) -> System.out.println("value is : " + x));
        // Provide two lambdas, one will be executed if value is present, the otehr one will be executed if value is empty
        middleName.ifPresentOrElse(
                (x) -> System.out.println("value is : " + x),
                () -> System.out.println("value if not present")
        );
    }
}

