package com.athingforcode.examples;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E02_ScheduledExecutorService {

    public static void main(String[] args) throws InterruptedException {
        //create a single threaded executor that can schedule task to run after a given delay
        try (var scheduler = Executors.newSingleThreadScheduledExecutor()) {
            var list = new ArrayList<String>();
            //schedule a task run to insert value into list in the next 2 seconds
            scheduler.schedule( () -> list.add("String - 1"),2, TimeUnit.SECONDS);

            Thread.sleep(1000);
            //Scheduled task hasn't run yet, list is still empty
            System.out.println("After 1 second, list content is : " + list);

            Thread.sleep(1500);
            //Scheduled task should have finished run, list should contain "String-1" now
            System.out.println("After 2.5 seconds, list content is : " + list);
            scheduler.shutdownNow();
        }
    }
}
