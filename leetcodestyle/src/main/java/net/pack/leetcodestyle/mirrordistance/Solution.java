package mirrordistance;

public class Solution {

    static void main() {
        Solution s = new Solution();
        System.out.println(s.mirrorDistance(25));
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString()));
    }
}
