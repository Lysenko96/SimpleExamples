package collection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(isIsogram(""));
        System.out.println(new Main().findNextSquare(121));
        System.out.println(new Main().sum(Arrays.asList(1,5,"3","2")));
        List<Integer> l = new ArrayList<>(3);
        l.add(1);
        l.add(3);
        l.add(4);
        Collections.fill(l, 2);
        Collections.addAll(l, Arrays.asList(3,5,1,5).toArray(new Integer[4]));
        System.out.println(Collections.frequency(l, 2));
        System.out.println(Collections.disjoint(Collections.singletonList(2), Collections.singletonList(2)));
        System.out.println(l);
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(1);
        System.out.println(s);
        System.out.println(s.pop());
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        print(new String[]{"str", "arb"});
        print(new Integer[]{32,235});
        System.out.println(disemvowel("LOL"));
    }

    public static String disemvowel(String str) {
        List<String> exclude = new ArrayList<>(Arrays.asList("A","O","E","U","I","a","o","e","u","i"));
        List<String> letters = new ArrayList<>(Arrays.asList(str.split("")));
        StringBuilder sb = new StringBuilder();
        for(String letter : letters){
            if(!exclude.contains(letter)){
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public static Integer basicMath(String op, int v1, int v2) {
        int result = 0;
        switch (op) {
            case "+": result = v1 + v2;
                break;
            case "-": result = v1 - v2;
                break;
            case "*": result = v1 * v2;
                break;
            case "/": result = v1 / v2;
                break;
            default:
                break;
        }
        return result;
    }

    public static <T extends Comparable<T>> void print(T[] arr){
        for(T elem : arr)
            System.out.println(elem);

        System.out.println();
    }

    public static boolean  isIsogram(String str) {
        Set<String> set = new HashSet<>(Arrays.asList(str.toLowerCase().split("")));
        return set.size() == str.length() || set.size() == 1;
    }

    public static long findNextSquare(long sq) {
        if(Math.pow((int)Math.sqrt(sq), 2) != sq) return -1;
        return (long) Math.pow((int)Math.sqrt(sq) + 1, 2);
    }

    public int sum(List<?> mixed) {
        List<Integer> result = new ArrayList<>();
        for(Object o : mixed){
            if(o instanceof String) result.add(Integer.valueOf(o.toString()));
            else result.add((Integer) o);
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

}
