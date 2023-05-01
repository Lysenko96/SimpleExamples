package examples.favorformat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Mission {

    Logbook logbook;
    LocalDate start;

    void update(String author, String message){
        final LocalDate today = LocalDate.now();
        String entry = String.format("%S: [%tm-%<te-%<tY](Day %d)>%s%n", author, today, ChronoUnit.DAYS.between(start, today) + 1, message); // use format for output
        logbook.write(entry);
    }

}

class Logbook {

    public void write(String entry){
        System.out.println(entry);
    }

}
