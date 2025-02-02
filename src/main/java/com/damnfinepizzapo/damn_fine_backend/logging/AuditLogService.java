package com.damnfinepizzapo.damn_fine_backend.logging;

import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class AuditLogService {
    private static final String LOG_FILE_PATH = "/home/LogFiles/audit-log.txt"; // File location

    public void logChange(String logEntry) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
