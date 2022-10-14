package info.lysenko.anton.ser;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime localDateTimeFrom = LocalDateTime.parse("2022-08-01-23-50", dateFormat);
        Calendar c = Calendar.getInstance();
        localDateTimeFrom = LocalDateTime.parse("2022-08-01-23-50", dateFormat);
        c.setTime(java.sql.Timestamp.valueOf(localDateTimeFrom));
        c.set(Calendar.HOUR_OF_DAY, localDateTimeFrom.getHour());
        c.set(Calendar.MINUTE, localDateTimeFrom.getMinute());
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date dateFrom = c.getTime();
        System.out.println(dateFrom);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(format.format(""));

        //        Test test = new Test();
//        try {
//            FileOutputStream fos = new FileOutputStream("/home/user/Documents/Spd/headfirst/obj.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(test);
//            System.out.println(test.getX() + test.getY() + test.getZ());
//            FileInputStream fis = new FileInputStream("/home/user/Documents/Spd/headfirst/obj.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            test = (Test) ois.readObject();
//            System.out.println(test.getX() + test.getY() + test.getZ());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    }
}

//class Test implements Serializable {
//
//    int x = 3;
//    transient long y = 4;
//    short z = 5;
//
//    public int getX() {
//        return x;
//    }
//
//    public long getY() {
//        return y;
//    }
//
//    public short getZ() {
//        return z;
//    }
//}
