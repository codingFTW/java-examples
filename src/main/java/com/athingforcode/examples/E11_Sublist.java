package com.athingforcode.examples;

import java.util.List;

public class E11_Sublist {

    public static void main(String[] args) {
        List<String> names = List.of(
                "Budi",
                "Ari",
                "Mulyono",
                "Sri",
                "Jamie",
                "Nigel",
                "Tuti"
        );

        //sublist from index 0 - 1
        var names_0_2 = names.subList(0,2);
        System.out.println(names_0_2);

        //sublist from index 3 - end
        var names_3_end = names.subList(3,names.size());
        System.out.println(names_3_end);

    }


}


