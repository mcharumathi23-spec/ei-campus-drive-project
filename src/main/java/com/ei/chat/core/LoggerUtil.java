package com.ei.chat.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("ei.chat");

    public static void logInfo(String msg) {
        logger.log(Level.INFO, msg);
    }

    public static void logError(String msg) {
        logger.log(Level.SEVERE, msg);
    }

    public static void logWarning(String msg) {
        logger.log(Level.WARNING,msg);
}
}