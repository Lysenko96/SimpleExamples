package findcommchar;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella","label","roller"}));
    }

    public List<String> commonChars(String[] words) {
        List<Map<String, Long>> list = new ArrayList<>();
        Set<String> uniqueSymbols = new HashSet<>();
        //System.out.println(Arrays.toString(words));
        List<String> sorted = Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).toList();
        //System.out.println(sorted);
        for (String s : sorted)
            list.add(Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //System.out.println(list);
        for(int i = 0; i < sorted.get(0).split("").length; i++){
            //System.out.println(sorted.get(0).split("")[i]);
            int counter = 0;
            for(Map<String, Long> m : list){
                if(m.containsKey(sorted.get(0).split("")[i])) {
                    counter++;
                }
            }
            if(counter == list.size()) {
                uniqueSymbols.add(sorted.get(0).split("")[i]);
                //System.out.println(sorted.get(0).split("")[i]);
            }
        }
        //System.out.println(uniqueSymbols);
        Map<String, Long> sortMap = new HashMap<>();
        for(String line : uniqueSymbols) {
            List<Long> counters = new ArrayList<>();
            for (Map<String, Long> m : list) {
                if(m.containsKey(line)) {
                    //System.out.println(line + " " + m.get(line));
                    counters.add(m.get(line));
                }
                Collections.sort(counters);
               // System.out.println(counters);
                sortMap.put(line, counters.get(0));
            }
        }
       //System.out.println(sortMap);
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Long> pair : sortMap.entrySet()){
            for(int i = 0; i < pair.getValue(); i++){
                result.add(pair.getKey());
            }
        }
        return result;
    }
}