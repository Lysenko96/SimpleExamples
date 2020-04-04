package LessonsToInterview.ExceptionTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainExceptionTest {
    FileInputStream fileInputStream;
    private MainExceptionTest() throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Антон\\IdeaProjects\\JDBCLessons\\src\\LessonsToInterview\\ExceptionTest\\test.txt")) {

            String text = "So close no matter how far\n" +
                    "Couldn't be much more from the heart\n" +
                    "Forever trusting who we are\n" +
                    "And nothing else matters";
            fileOutputStream.write(text.getBytes());
        }
        fileInputStream = new FileInputStream("C:\\Users\\Антон\\IdeaProjects\\JDBCLessons\\src\\LessonsToInterview\\ExceptionTest\\test.txt");
        try(Scanner in = new Scanner(fileInputStream)){
            int i;
            while ((i=fileInputStream.read())!= -1){
                System.out.print((char)i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new MainExceptionTest();
    }
}
