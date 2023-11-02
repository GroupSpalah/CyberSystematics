package ls_10_23.ls_02_11_23.dates;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Task2 {
    public static void main(String[] args) {

        ZoneId zoneId = ZoneId.of("America/Shiprock");

        LocalDateTime time = LocalDateTime.now(zoneId);

        System.out.println(time);

        print("John");
    }

    public static void print(String name) {
        System.out.println();
    }
}
