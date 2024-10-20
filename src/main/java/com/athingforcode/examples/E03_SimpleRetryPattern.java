package com.athingforcode.examples;

import java.util.Optional;
import java.util.function.Supplier;

public class E03_SimpleRetryPattern {
    public static void main(String[] args) {
        // Example usage of retryOperation
        Optional<String> result = retryOperation(() -> {
            // Simulating an operation that might fail
            if (Math.random() <= 0.5) {
                throw new RuntimeException("Random failure");
            }
            return "Operation successful";
        }, 3, "Sample Operation");

        result.ifPresentOrElse(
                value -> System.out.println("Result: " + value),
                () -> System.out.println("Operation failed after all retries")
        );

        // Example usage of retryVoidOperation
        try {
            retryVoidOperation(() -> {
                // Simulating a void operation that might fail
                if (Math.random() < 0.5) {
                    throw new RuntimeException("Random failure in void operation");
                }
                System.out.println("Void operation successful");
            }, 3, "Sample Void Operation");
        } catch (RuntimeException e) {
            System.out.println("Void operation failed after all retries: " + e.getMessage());
        }
    }

    /**
     * Executes a supplier operation with retry logic.
     *
     * @param <T> The type of the result returned by the supplier
     * @param op The supplier operation to be executed
     * @param maxRetry The maximum number of retry attempts
     * @param operationName The name of the operation for error reporting
     * @return An Optional containing the result of the operation, or empty if all retries fail
     * @throws RuntimeException if the maximum number of retries is exceeded
     */
    public static <T> Optional<T> retryOperation(Supplier<T> op, int maxRetry, String operationName) {
        T result = null;
        int retryCounter = 1;
        var done = false;
        while((retryCounter <= maxRetry) && !done) {
            try {
                result = op.get();
                done = true;
            }
            catch(Exception ex) {
                retryCounter++;
                if (retryCounter <= maxRetry) {
                    System.out.println("retry - " + retryCounter);
                }
            }
        }
        if (retryCounter > maxRetry) {
            throw new RuntimeException("Too many retries on " + operationName);
        }
        return Optional.ofNullable(result);
    }

    /**
     * Executes a void operation with retry logic.
     *
     * @param op The runnable operation to be executed
     * @param maxRetry The maximum number of retry attempts
     * @param operationName The name of the operation for error reporting
     * @throws RuntimeException if the maximum number of retries is exceeded
     */
    public static void retryVoidOperation(Runnable op, int maxRetry, String operationName) {
        int retryCounter = 1;
        var done = false;
        while((retryCounter <= maxRetry) && !done) {
            try {
                op.run();
                done = true;
            }
            catch(Exception ex) {
                retryCounter++;
                if (retryCounter <= maxRetry) {
                    System.out.println("retry-" + retryCounter);
                }
            }
        }
        if (retryCounter > maxRetry) {
            throw new RuntimeException("Too many retries on " + operationName);
        }
    }
}
