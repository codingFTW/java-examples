package com.athingforcode.examples;

public class E07_TextBlock {
    public static void main(String[] args) {
        //Text blocks start and end with triple quotes ("""). They preserve formatting and don't require escape characters for line breaks.
        String jsonTextBlock = """
        {
           "person": {
             "name": "Gatotkaca",
             "age": 30,
             "isStudent": false,
             "address": {
               "street": "Kartosuro",
               "city": "Solo",
               "country": "Indonesia"
             },
             "phoneNumbers": [
               "+62-21-555-1234",
               "+62-21-555-5678"
             ],
             "skills": [
               "Java",
               "Python",
               "JavaScript"
             ],
             "projects": [
               {
                 "name": "Project A",
                 "year": 2022
               },
               {
                 "name": "Project B",
                 "year": 2023
               }
             ]
           }
         }
        """;

        System.out.println(jsonTextBlock);
    }
}
