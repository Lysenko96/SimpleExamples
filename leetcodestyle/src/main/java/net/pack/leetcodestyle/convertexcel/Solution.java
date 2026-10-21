//package net.pack.leetcodestyle.convertexcel;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.convertToTitle(2147483647));
//        System.out.println(s.convertToTitle(1));
//        System.out.println(s.convertToTitle(52));
//        System.out.println(s.convertToTitle(701));
//        System.out.println(s.convertToTitle(28));
//    }
//
//    private Map<Integer, String> alphabet1 = new HashMap<>() {{
//        put(1, "A");
//        put(2, "B");
//        put(3, "C");
//        put(4, "D");
//        put(5, "E");
//        put(6, "F");
//        put(7, "G");
//        put(8, "H");
//        put(9, "I");
//        put(10, "J");
//        put(11, "K");
//        put(12, "L");
//        put(13, "M");
//        put(14, "N");
//        put(15, "O");
//        put(16, "P");
//        put(17, "R");
//        put(18, "S");
//        put(19, "T");
//        put(20, "U");
//        put(21, "V");
//        put(22, "W");
//        put(23, "X");
//        put(24, "Y");
//        put(25, "Z");
//    }};
//
//    private String[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
//
//    public String convertToTitle(int columnNumber) {
//        StringBuilder result = new StringBuilder();
//        StringBuilder middle = new StringBuilder();
//        long res3 = columnNumber / 26;
//        if (columnNumber > 26) {
//            while (res3 > 26) {
//                res3 /= 26;
//            }
//            result.append(alphabet[((int) res3 % 26) - 1]);
//        }
//        if (columnNumber > 26 && columnNumber % 26 != 0) {
//            long res1 = columnNumber / 26;
//            int res2 = 0;
//            while (res1 > 26) {
//                res2 = (int) (res1 % 26);
//                middle.append(alphabet[res2 - 1]);
//                res1 /= 26;
//            }
//            middle.reverse();
//            result.append(middle);
//            result.append(alphabet[columnNumber % 26 - 1]);
//        } else if (columnNumber % 26 == 0) {
//            result.append(alphabet[25]);
//        } else {
//            result.append(alphabet[columnNumber - 1]);
//        }
//        return result.toString();
//    }
//}
