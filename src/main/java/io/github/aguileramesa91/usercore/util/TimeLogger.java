package io.github.aguileramesa91.usercore.util;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeLogger {

    private static final String FILE_NAME = "execution_logs.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



    public static void logExecutionTime(String operation, long startTime){
        long duration = System.currentTimeMillis() - startTime;
        String timestamp = LocalDateTime.now().format(formatter);

        String logMessage = String.format("[%s] OPERATION: %s | DURATION: %d ms",
                timestamp, operation, duration);
        System.out.println("\u001B[36m" + logMessage + "\u001B[0m");

        try (FileWriter fw = new FileWriter((FILE_NAME), true);
             PrintWriter out = new PrintWriter(fw)) {

            out.println(logMessage);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


}
