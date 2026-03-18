package io.github.aguileramesa91.usercore.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logExecutionTime(String operation, long startTime){
        long duration = System.currentTimeMillis() - startTime;
        String timestamp = LocalDateTime.now().format(formatter);

        String logMessage = String.format("[%s] OPERATION: %s | DURATION: %d ms",
                                          timestamp, operation, duration);

        System.out.println("\u001B[36m" + logMessage + "\u001B[0m");
    }
}
