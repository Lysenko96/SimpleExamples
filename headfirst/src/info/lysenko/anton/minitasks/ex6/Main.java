package info.lysenko.anton.minitasks.ex6;

import java.util.Arrays;
import java.util.Comparator;

public class Main implements Comparator<Integer>{

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2,3,1,9,-2};
        System.out.println(Arrays.toString(a));
        sort(a, true);
        System.out.println(Arrays.toString(a));
        sort(a, false);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(Integer[] a, boolean up) {
        sort(a, null,0, a.length - 1, up, new Main());
    }


    public static void sort(Object[] a, Object[] b, int from, int to, boolean up, Comparator c) {
        if ((a == null) || (a.length < 2)) return;
        int i = from;
        int j = to;
        Object center = a[(from + to) / 2];
        do {
            if (up) {
                while ((i < to) && (c.compare(center, a[i]) > 0)) i++;
                while ((j > from) && (c.compare(center, a[j]) < 0)) j--;
            } else {
                while ((i < to) && (c.compare(center, a[i]) < 0)) i++;
                while ((j > from) && (c.compare(center, a[j]) > 0)) j--;
            }
            if (i < j) {
                Object tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            if (i <= j) {
                i++;
                j--;
            }
        } while (i <= j);
        if (from < j)
            sort(a, b, from, j, up, c);

        if (i < to)
            sort(a, b, i, to, up, c);
    }

    @Override
    public int compare(Integer integer, Integer t1) {
        return integer.compareTo(t1);
    }
}
