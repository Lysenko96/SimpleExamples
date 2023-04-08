package lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Function;

public class Main1 {

    public static final String FILENAME = "data.txt";
    public static final String SPACE = " ";

    int a;

    public static void main(String[] args) {
       Main1 main = new Main1();

        try {
            System.out.println(main.processFile((br) -> br.readLine() + SPACE + br.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(main.processFile(BufferedReader::readLine));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Function<BufferedReader, String> readerStringFunction = br -> {
            String res = null;
            try {
                res = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        };



        try {
            System.out.println(readerStringFunction.apply(new BufferedReader(new FileReader(FILENAME))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Comparator c = null;
    }

    void show(){
        Function<BufferedReader, String> readerStringFunction2 = br -> {
            String res = null;
            try {
                res = br.readLine() + SPACE + br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        };

        try {
            System.out.println(readerStringFunction2.apply(new BufferedReader(new FileReader(FILENAME))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String processFile(BufferReaderFuncInterface funcInterface) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            return funcInterface.getStrLines(br);
        }
    }
    Object o;
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

@FunctionalInterface
interface BufferReaderFuncInterface {

    @Override
    int hashCode();

    boolean equals(Object o1);

        String getStrLines(BufferedReader br) throws IOException;

    }