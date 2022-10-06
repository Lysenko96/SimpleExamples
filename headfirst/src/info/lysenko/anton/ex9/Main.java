package info.lysenko.anton.ex9;

import java.util.Calendar;

import static java.lang.System.out;

public class Main {

    public static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004,0,7,15,40);
        long day1 = c.getTimeInMillis();
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.format("foolmoon: %tc", c);
        out.println();
        c.set(2004,1,7,15,40);
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.format("foolmoon: %tc", c);
        out.println();
        day1 += (DAY_IM * 29.52);
        c.setTimeInMillis(day1);
        out.format("foolmoon: %tc", c);
    }
}
