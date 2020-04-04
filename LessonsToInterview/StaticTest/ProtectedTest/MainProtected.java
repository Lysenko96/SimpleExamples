package LessonsToInterview.StaticTest.ProtectedTest;

import LessonsToInterview.StaticTest.StaticMain;

import java.util.Arrays;

public class MainProtected extends StaticMain     {
    protected  int d = 5;
     int[] arr = new int[] {1,3,4};
     int[] arr1 = new int[3];

    MainProtected(){
         //String s;
        Object object = new MainProtected2( "Anton");
        MainProtected2 mainProtected2 = (MainProtected2) object;
        System.out.println(mainProtected2.getName());
        object = arr;
        arr1 = (int[]) object;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        String s = Arrays.toString((int[]) object);
        System.out.print(s + " ");
    }


    public static void main(String[] args) {
        new MainProtected();

    }


}


class D1{
    void showD1(){
        System.out.println(new MainProtected().d);
    }
}
