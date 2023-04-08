package info.lysenko.anton.patterns.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(2).compareTo(new BigDecimal("2")) == 0 );
        List<String> list = new ArrayList<>();
        list.contains("");
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
        tea.prepareRecipe();
        System.out.println();
        coffee.prepareRecipe();
        Map<String, String> map = Stream.of(new String[][]{{"a", "1"},{"b", "2"}}).collect(Collectors.toMap(str -> str[0], str -> str[1]));
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append("?");
            //System.out.println(String.join("?", new String[]{","}));
            sb.append(String.join("?", new String[]{","}));
        }
        System.out.println(sb);
        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("12");
        l.add("13");
        StringBuilder sb1 = new StringBuilder();
        l.stream().sorted().forEach(s -> sb1.append(Arrays.toString(s.split(" "))));
        System.out.println(sb1);
    }
}
