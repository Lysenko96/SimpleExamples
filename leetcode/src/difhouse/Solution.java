//package difhouse;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().maxDistance(new int[]{4,4,4,11,4,4,11,4,4,4,4,4}));
//    }
//
//    public int maxDistance(int[] colors) {
//        int f = colors[0];
//        List<Integer> l = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        for (Integer i : colors) {
//            l.add(i);
//        }
//        l2 = l.stream().filter(n -> n != f).toList();
//        //System.out.println(l2);
//        int last = l2.get(l2.size() - 1);
//        int linkF = 0;
//        int linkL = 0;
//        for (int i = 0; i < colors.length; i++) {
//            if (colors[i] == last)
//                linkL = i;
//        }
////        System.out.println(linkF);
////        System.out.println(linkL);
//        return Math.abs(linkL - linkF);
//    }
//}
