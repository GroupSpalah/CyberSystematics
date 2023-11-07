package ls_10_23.ls_02_11_23.dates;

import ls_10_23.ls_28_10_23.Man;
import ls_11_23.ls_07_11_23.Manager;
import ls_11_23.ls_07_11_23.Position;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Task1 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        LocalDateTime myBirthDay = LocalDateTime.of(1985, Month.MAY, 1, 0, 0);

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.plusYears(2);

        long years = ChronoUnit.YEARS.between(myBirthDay, now);

        System.out.println(years);

        Date date = new Date();

        date.setHours(1);

        Position position = new Position();

        Object position1 = (Manager) new Object();


    }

}
