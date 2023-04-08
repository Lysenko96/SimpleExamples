import info.lysenko.anton.MainState;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.awt.*;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class Main {

    static int x = 5;
    int f = 10;
    static int sf = 15;

    void test(){
        int var = 5;
        Runnable r1 = () -> System.out.println(var);
        Runnable r2 = () -> System.out.println(f);
        Runnable r3 = () -> System.out.println(sf);
        f = 4;
        sf = 4;
        r1.run();
        r2.run();
        r3.run();
    }

    public static void main(String[] args) {

        new Main().test();

        List<IntSupplier> l = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            x++;
            int xx = x;
            IntSupplier l1 = () -> xx + xx;
            l.add(l1);
        }
        for(IntSupplier s : l){
            System.out.println(s.getAsInt());
        }

        SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = localDateFormat.format(new Date());
        LocalDateTime ltd = LocalDateTime.parse(time, dateTimeFormatter);
        System.out.println(ltd);


        SimpleDateFormat localDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        String time2 = localDateFormat2.format(new Date().getTime() + 10000000L);
        System.out.println(time2);




//        class User {
//            String name;
//
//            public User(String name) {
//                this.name = name;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            @Override
//            public String toString() {
//                return "User{" +
//                        "name='" + name + '\'' +
//                        '}';
//            }
//        }
//        List<User> names = new ArrayList<>();
//        names.add(new User("name"));
//        names.add(null);
//        names.add(new User("null"));
//        names.sort(Comparator.nullsFirst(Comparator.comparing(User::getName)));
//        System.out.println(names);
//        //for(String s : names) System.out.println(s.length());
//        names.sort(Comparator.comparing(User::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
//        System.out.println(names);
        //for(String s : names) System.out.println(s.length());
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "2");
//        System.out.println(map);
//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> pair = it.next();
//            if (pair.getKey().equals("1"))
//               it.remove();
//        }
//        map.entrySet().removeIf(pair -> pair.getKey().equals("1"));
//        map.entrySet().stream().collect(Collectors.counting());
//        System.out.println(map);
//        String smap = String.join(",", map.values());
//        System.out.println(smap);
//        class Point {
//            int x,y;
//
//            int print(Point this){
//                System.out.println(this.x + " " + this.y);
//                return x + y;
//            }
//        }
//        Point p = new Point();
//        p.x = 1;
//        p.y = 2;
//        System.out.println(p.print());
//
//        List<String> s = new ArrayList<>();
//        Color color = new Color(Color.BLACK.getRGB());
//        System.out.println(color);
//        s.add("asdfasf");
//        System.out.println(s);
//        new Date();
//        int num = 0;
//        int x;
//        if (Math.random() > 0.5)
//            x = 1;
//        else x = 0;
//        System.out.println(x);
//        System.out.println(num++);
//        System.out.println(num);
//
//        {
//            int a = 0;
//            System.out.println(a);
//        }
//
//        //System.out.println(a); not found
//
//        if(true)
//            if(true)
//                System.out.println("true");
//        else
//                System.out.println("???");


        //System.out.println("res:" + Math.floor(-51.25));

//        File file = new File("/home/user/dir11");
//        boolean b = file.mkdirs();
//        Long i = new BigDecimal(-560072102).divide(new BigDecimal(60000), 0, RoundingMode.HALF_UP).longValueExact();
//        Integer c = new BigDecimal(-560072102).divide(new BigDecimal(60000), 0, RoundingMode.HALF_UP).intValueExact() * 60000;
//        System.out.println(i * 60000);
//        System.out.println(c);
//        System.out.println(new BigDecimal(i).multiply(new BigDecimal(60000)));
//        System.out.println(new Integer(-348303102)/ 60000.0 / 60.0);
//        System.out.println(-5500 * 60000);
//        System.out.println(new BigDecimal(-348300000).divide(new BigDecimal(60000), 5, RoundingMode.HALF_UP));
//        System.out.println(new BigDecimal(-348300000).divide(new BigDecimal(60000), 5, RoundingMode.HALF_UP).multiply(new BigDecimal(60000)));
//        System.out.println(new BigDecimal(-348303102).divide(new BigDecimal(60000), 5, RoundingMode.HALF_UP));
//        System.out.println(new BigDecimal(-348303102).divide(new BigDecimal(60000), 5, RoundingMode.HALF_UP).multiply(new BigDecimal(60000)));
//        System.out.println(new BigDecimal(new BigDecimal(i).divide(BigDecimal.valueOf(60000), 0, RoundingMode.HALF_UP).intValueExact()).multiply(new BigDecimal(60000)).longValueExact());
    }
}
