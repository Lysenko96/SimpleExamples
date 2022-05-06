package net.pack.tasksnleet.sortbybits;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }

    public int[] sortByBits(int[] arr) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] bits = Integer.toBinaryString(arr[i]).split("");
            int countBits = 0;
            for (String bit : bits) {
                if (bit.equals("1")) {
                    countBits++;
                }
            }
            entries.add(new Entry(arr[i], countBits));
        }
       List<Entry> sortedEntries = entries.stream().sorted(Comparator.comparing(Entry::getValue).thenComparing(Entry::getKey)).collect(Collectors.toList());
        int index = 0;
        for(Entry e : sortedEntries){
            arr[index] = e.getKey();
            index++;
        }
        return arr;
    }
}

class Entry {

    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}