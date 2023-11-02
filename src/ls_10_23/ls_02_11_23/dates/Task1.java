package ls_10_23.ls_02_11_23.dates;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime myBirthDay = LocalDateTime.of(1985, Month.MAY, 1, 0, 0);

        LocalDateTime now = LocalDateTime.now();

        long years = ChronoUnit.YEARS.between(myBirthDay, now);

        System.out.println(years);
    }
}
