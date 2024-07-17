package org.example.entity;

import java.util.function.Function;
import java.util.stream.Stream;

public enum Style {

    X("X"),Y,Z;

    Style() {

    }

    private int xyz;

    Style(String s) {

    }

    void show() {

    }
}

class D {
    void show(){
        System.out.println(Style.X.name());
    }

}

record GeoPlace(String lat, String lng, int k) implements A {

    private static  int a = 33;
    public static final Long c=0L;

    protected static int z;

    GeoPlace(String l, String n, int k, int z){
        this(l,n,k);
        GeoPlace.z = z;
    }

    @Override
    public void go() {

    }

    GeoPlace(String lat, String lng, int k) {
     this.lat = lat;
     this.lng = lng;
     if(k > 10) {
         k = 2;
     }
     this.k = k;
 }

   static int check() {

       return 0;
   }
   public void show(){
       System.out.println(k);
   }

    public static void main(String[] args) {
        GeoPlace geoPlace = new GeoPlace("lng","lat",1);
        System.out.println(geoPlace.k);
        GeoPlace geoPlace1 = new GeoPlace("lng","lat",11);
        System.out.println(geoPlace1.k);
        System.out.println(GeoPlace.a);
        System.out.println(GeoPlace.a);


        GeoPlace geoPlace2 = new GeoPlace("lng","lat",11);
        geoPlace2.showMy();

    }


   private void showMy() {
        Lambda lambda = (s) ->   {
            this.a = 3;
            return s + "lambda" + this.a;
        };
        lambda.apply("1");


       Anonymous anonymous = new Anonymous() {
           int k= 3;
           @Override
           String method(String s) {
               return s + "method" + a + this.k;
           }

           @Override
           public String apply(String s) {
               return s + "lambda" + a;
           }
       };
       anonymous.apply("1");
       Stream.of("2").map(lambda).forEach(System.out::println);
       Stream.of("3").map(anonymous).forEach(System.out::println);

   }


}


abstract class Anonymous implements Function<String, String> {
    abstract String method(String s);
}

@FunctionalInterface
interface Lambda extends Function<String, String> {
//    String method(String s);
}