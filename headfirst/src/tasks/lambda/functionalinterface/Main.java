package tasks.lambda.functionalinterface;

public class Main {

    public static void main(String[] args) {

    }
}
@FunctionalInterface
interface Adder {
    void add(int a, int b);

    default void show(){ };

    default String getString(String str) {
        return str;
    }
}
@FunctionalInterface
interface SmartAdder extends Adder {
    //@Override
    //void add(double a, double b);
}


@FunctionalInterface
interface CharSupplier extends StringSupplier {

    @Override
    default String getString() {
        return String.valueOf(getChar());
    }

    char getChar();
}

@FunctionalInterface
interface StringSupplier {

    String getString();
}
