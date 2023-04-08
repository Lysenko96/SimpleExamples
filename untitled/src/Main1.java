import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {

//    public static void main(String[] args) {
////
//
//
////        List<A> l = new ArrayList<>();
////        l.add(new A(1));
////        l.add(new A(2));
////        l.add(new A(3));
////        for(A s : l){
////            if(s.a == 2){
////                l.remove(s);
////            }
////        }
//        //l.removeIf(s -> s.equals("2"));
////        Predicate<Integer> p = x -> x < 1;
////        Consumer<Integer> consumer = x -> System.out.println(x);
////        consumer.accept(1);
////        Function<Integer, String> function = x -> x.toString();
////        function.apply(3);
////        Supplier<Integer> supplier = () -> new Integer(3);
////        supplier.get();
////        System.out.println(p.test(1));
////        Stream<A> stream = l.stream();
//      //  stream.forEach(x -> System.out.println(x));
//        //stream.forEach(x -> System.out.println(x));
//        //stream.forEach(x -> System.out.println(x));
//        //System.out.println(l);
//
//
//        //YearMonth.of()
//
//        Optional<String> s = Optional.ofNullable(null);
//        if(s.isPresent()) System.out.println(s.get());
//
////        Stream.of(4,5).map(A::new).forEach(System.out::println);
////        Stream.of(4,5).map(A::new).collect(Collectors.toCollection(ArrayList::new));
////
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
////        LocalDate localDate = LocalDate.now();
//
//
//
//        //Stream<Integer> streamInt = Stream.of(2,3,4);
//        Stream<String> streamInt2 = Stream.of("dfs","xcv","gdvfsDSF");
//        Stream<String> streamInt3 = Stream.of("dfs","xcv","gdvfsDSF");
//        // streamInt.map(n -> n.doubleValue()).filter(n -> n != 3).forEach(System.out::println);
//
//        streamInt2.map(n2 -> {
//            //System.out.println("toLowerCase");
//            return n2.toLowerCase();
//        }).filter(n2 -> {
//            //System.out.println("dfs");
//            return n2.equals("dfs");
//        }).forEach(x -> System.out.println(x));
//
//        streamInt3.filter(n2 -> {
//           // System.out.println("dfs");
//            return n2.equals("dfs");
//        }).map(n2 -> {
//           // System.out.println("toLowerCase");
//            return n2.toLowerCase();
//        }).forEach(x -> System.out.println(x));
//
////        ForkJoinPool forkJoinPool = new ForkJoinPool();
////        System.out.println("forkJoinPool.getParallelism(): " +  forkJoinPool.getParallelism());
//
//       // Supplier<Stream<Integer>> supplier = () -> Stream.of(5,6,7);
//      //  supplier.get().forEach(System.out::println);
//       // supplier.get().forEach(System.out::println);
//
//
//
////        System.out.println(l.stream().filter(a -> {
////            System.out.println(a);
////            return a.a == 1;
////        }).count());
////        System.out.println(l.stream().filter(a -> {
////            System.out.println(a);
////            return a.a == 1;
////        }));
//       // Stream.of(Arrays.asList(1,2),Arrays.asList(3,4)).flatMap(x -> x.stream()).forEach(x -> System.out.println(x));
//
//    //Stream s = new ArrayList<>().stream().
//    }
////}


    public static void main(String[] args) {
        new C().defaultMethod();
    }

}


class C implements A, B {

    @Override
    public void defaultMethod() {
        B.super.defaultMethod();
    }

}

interface A {
    default void defaultMethod(){
        System.out.println("defaultMethodA");
    }
}

interface  B {

    default void defaultMethod(){
        System.out.println("defaultMethodB");
    }
}


//class A {
//    int a;
//
//    public A(int a) {
//        this.a = a;
//    }
//
//    @Override
//    public String toString() {
//        return "A{" +
//                "a=" + a +
//                '}';
//    }
//}

//1.Java Core (v8)
//        функциональное программирование - без возможности в процессе выполнения изменения внутреннего состояния метода со внешней стороны (переменные в лямбдах final)
//        лямбда - интерфейс с одним методом
//        функциональные интерфейсы
//        Predicate Object -> Boolean (test)
//        Consumer Object -> void (accept)
//        Function Input(Type) -> Output(DiffType) (apply)
//        Supplier void -> Object (get)
//        стримы принимают функциональные интерфейсы для обработки коллекции
//        Intermediate operations are not executed until some terminal operation is invoked
//        ------Intermediate:
//        filter()
//        map()
//        flatMap()
//        distinct()
//        sorted()
//        peek()
//        limit()
//        skip()
//        -----Terminal:
//        forEach()
//        forEachOrdered()
//        toArray()
//        reduce()
//        collect()
//        min()
//        max()
//        count()
//        anyMatch()
//        allMatch()
//        noneMatch()
//        findFirst()
//        findAny()
//        ---------
//default, static методы в интерфесах добавлены
//        optional, обертка над null pointer, для обработки ошибки
//        method references - сокращенные записи для лямбд
//        parallel streams - иногда могут быть эффективны ускорить работу иногда нет
//        LocalDate,LocalDateTime,ZonedDateTime (This class is immutable and thread-safe), DateTimeFormatter (final), SimpleDateFormat(not final)
//        предаставляет API для более коротких записей при работе с датами
//        2.Java Memory Model
//        несколько уровней кэша для потоков и общий кеш
//        Classes, Interfaces, Enumerations (интерфейс предок Iterator)
//        Generics - для безопасности коллекционирования объектов на этапе компиляции
//        Strings - immutable, pool String - хранится кеш строк, через new можно создать в куче
//        Arrays - объект для коллекционирования определенного типа данных с ограниченным размером
//        Annotations - мета данные для языка java, custom annotation задавать свою логику для обработки классов, переменных, методов
