package net.pack.lambdafilter;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("", null, "sdf"));
        List<String> strs = strings.stream().filter(s -> s == null).collect(Collectors.toList());
        System.out.println(strs);

        System.out.println(strs.get(0));
    }
}
