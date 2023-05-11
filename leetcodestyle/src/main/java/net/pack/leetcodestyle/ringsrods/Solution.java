package net.pack.leetcodestyle.ringsrods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countPoints("B0G0R1R0"));
    }

    public int countPoints(String rings) {
        int count = 0;
        String[] ringsArr = rings.split("");
        List<Ring> ringsList = new ArrayList<>();
        for (int i = 0; i < ringsArr.length; i += 2) {
            ringsList.add(new Ring(ringsArr[i + 1], ringsArr[i]));
        }
        List<String> listIds = new ArrayList<>();
        for (Ring ring : ringsList) {
            listIds.add(ring.getId());
        }
        List<String> ids = listIds.stream().distinct().collect(toList());
        for (String id : ids) {
            List<String> uniqueL = new ArrayList<>();
            for (Ring ring : ringsList) {
                if (ring.getId().equals(id)) {
                    uniqueL.add(ring.getColor());
                }
            }
            if(uniqueL.containsAll(Arrays.asList("R", "G", "B"))){
                count++;
            }
        }
        return count;
    }
}

class Ring {

    private String id;
    private String color;

    public Ring(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ring ring = (Ring) o;
        return id.equals(ring.id) && color.equals(ring.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
