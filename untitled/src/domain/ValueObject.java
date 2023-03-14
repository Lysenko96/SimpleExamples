package domain;

import java.util.Arrays;
import java.util.Random;

public class ValueObject {

    private final String constant;
    private String[] arr = new String[]{"a","b","c"};
    private int value = new Random().nextInt(2);

    public ValueObject(){
        constant = arr[value];
    }

    public ValueObject(String[] arr, int value) {
        this.arr = arr;
        this.value = value;
        this.constant = arr[value];
    }

    public String getConstant() {
        return constant;
    }

    public String[] getArr() {
        return arr;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "constant='" + constant + '\'' +
                ", arr=" + Arrays.toString(arr) +
                ", value=" + value +
                '}';
    }
}
