package org.example.pattern.immutableinterface;

public final class SingleObject implements Cloneable {

    final String name;
    final SingleParam value;

    public SingleObject(String name, SingleParam value) {
        this.name = name;
        this.value = value;
    }

    public SingleParam getValue() throws CloneNotSupportedException {
        return value.clone();
    }

    @Override
    protected SingleObject clone() throws CloneNotSupportedException {
        SingleParam copy = value.clone();
        return new SingleObject(name, copy);
    }

//    @Override
//    public String toString() {
//        return "SingleObject{" +
//                "name='" + name + '\'' +
//                ", value=" + value +
//                '}';
//    }

    public static void main(String[] args) {
        SingleParam singleParam = new SingleParam("param");
        SingleObject singleObject = new SingleObject("hello", singleParam);
        System.out.println(singleObject);
        try {
        SingleObject clone = singleObject.clone();
            System.out.println(clone);
            System.out.println(singleObject.getValue());
            System.out.println(clone.getValue());
            System.out.println(singleObject.getValue() == clone.getValue());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}

class SingleParam  implements Cloneable {

    final String name;

    public SingleParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected SingleParam clone() throws CloneNotSupportedException {
        return (SingleParam) super.clone();
    }

//    @Override
//    public String toString() {
//        return "SingleParam{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
