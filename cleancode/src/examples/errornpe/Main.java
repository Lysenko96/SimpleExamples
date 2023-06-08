package examples.errornpe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test(){
        List<MyObj> myList = Arrays.asList(new MyObj(new Date(), "1"), new MyObj(new Date(new Date().getTime() - 86400000L), "2"), new MyObj(new Date(new Date().getTime() - (86400000L * 2)), null));
        // NPE - error
//        Map<Long, String> map = myList.stream().collect(Collectors.
//                				toMap(e -> e.getDate().getTime(), e -> e.getDuration()));
//        System.out.println(map);
        // no NPE - error
        Map<Long, String> map2 = new HashMap<>();
        for(MyObj o : myList){
            map2.put(o.getDate().getTime(), o.getDuration());
        }
        System.out.println(map2);

    }

    static class MyObj {
        Date date;
        String duration;

        public MyObj(Date date, String duration) {
            this.date = date;
            this.duration = duration;
        }

        public Date getDate() {
            return date;
        }

        public String getDuration() {
            return duration;
        }
    }
}
