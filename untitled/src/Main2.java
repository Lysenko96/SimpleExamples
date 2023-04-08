import java.util.*;

public class Main2 {

    List<String> stringList = new ArrayList<>(Arrays.asList("1","2","3","1"));

    public static void main(String[] args) {
        Main2 main2 = new Main2();
//        System.out.println(main2.checkFreqOld("1"));
//        System.out.println(main2.checkFreqOld("2"));
//        System.out.println(main2.checkFreq("1"));
//        System.out.println(main2.checkFreq("2"));
        String s1 = "abc";
        String s2 = new String("abc");
//        String s3 = new String("foo");
//        String s4 = s1.intern();
        String s5 = s2.intern();
        //System.out.println(s3 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s2);
    }



    int checkFreqOld(String line){
        if(line == null) throw new NullPointerException("not null");

        int counter = 0;
        for(String s : stringList){
            if(line.equals(s)){
                counter++;
            }
        }
        return counter;
    }

    int checkFreq(String line){
        Objects.requireNonNull(line, "not null");
        return Collections.frequency(stringList, line);
    }
}
