package com.example.springbootquicklymvc.entity;

import java.util.Objects;

public class MyDto {

    private Boolean value;

    public MyDto() {
    }

    public MyDto(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDto myDto = (MyDto) o;
        return Objects.equals(value, myDto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "MyDto{" +
                "value=" + value +
                '}';
    }
}
