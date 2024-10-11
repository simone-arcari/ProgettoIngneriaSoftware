package it.unicusano.simonearcari;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemLog {
    private static boolean active = false;

    public static void setActive(boolean val) {
        active = val;
    }

    public static void println(String str) {
        if (active) {
            System.out.println(getTimestamp() + str);
        }
    }

    public static void print(String str) {
        if (active) {
            System.out.print(getTimestamp() + str);
        }
    }

    private static String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + LocalDateTime.now().format(formatter) + "] ";
    }
}
