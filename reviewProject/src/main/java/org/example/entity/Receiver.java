package org.example.entity;


class Receiver {

    void show() {
    }

    public static void main(String[] args) {
        B b = new B() {
            @Override
            public void show() {
                System.out.println();
            }

            @Override
            public void go() {

            }
        };
    }
}

interface A {

    void show();
    void go();
}

abstract class B implements A {

    public abstract void show();

    public void screen() {
        System.out.println("screen");
    };
}

class C extends B {
    @Override
    public void show() {

    }

    @Override
    public void go() {

    }
}

abstract class K implements A {
    private enum Style {

    }
    @Override
    public void show() {

    }

//    @Override
//   public abstract  void go();
}

