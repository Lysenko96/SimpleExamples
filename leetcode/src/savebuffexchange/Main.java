package savebuffexchange;

import java.nio.CharBuffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.wrap("hello");
        Scanner scanner = new Scanner(buffer);
    }
}
