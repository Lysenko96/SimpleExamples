package streamtest2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        List<Dish> menu = Arrays.asList(new Dish(2000, false, "dish1"), new Dish(200, true, "dish3"), new Dish(1200, true, "dish2"));
//
//        List<Dish> menu2 = new ArrayList<>();
//
//        System.out.println(menu.stream()
//                .filter(d -> {
//                    System.out.println(d);
//                    return d.isVegetarian(); // true, false
//                })
//                //.collect(Collectors.toList()));
//                .anyMatch(Dish::isVegetarian));
//
//        boolean isHealthy = menu.stream().filter(d -> {
//            System.out.println(d);
//            return true;
//        }).allMatch(d -> d.getCalories() < 1500);
//
//        System.out.println(isHealthy);
//
//        isHealthy = menu.stream().filter(d -> {
//            System.out.println(d);
//            return true;
//        }).noneMatch(d -> d.getCalories() == 200);
//
//        System.out.println(isHealthy);
//
//        System.out.println(menu.stream().filter(Dish::isVegetarian).findAny());
//        System.out.println(menu.stream().filter(Dish::isVegetarian).findAny().get());
//        System.out.println(menu.stream().filter(Dish::isVegetarian).findAny().isPresent());
//        System.out.println(menu.stream().filter(d -> d.getCalories() > 5000).findAny().orElseGet(() -> new Dish()));
//        //System.out.println(menu.stream().filter(d -> d.getCalories() > 5000).findAny().orElseThrow(() -> new RuntimeException()));
//
////        List<Integer> someNumbers1 = new ArrayList<>(Arrays.asList(2));
////        someNumbers1.add(1);
////        System.out.println(someNumbers1);
////        List<Integer> someNumbers2 = Arrays.asList(2);
////        someNumbers2.add(1);
////        System.out.println(someNumbers2);
//
//        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<Integer> numbers = Arrays.asList(1, 2, 6, 3, 4);
//        Optional<Integer> firstSquareDivisibleByThree =
//                someNumbers.stream()
//                        //.parallel()
//                        .map(n -> n * n)
//                        .filter(n -> n % 3 == 0)
//                        .findAny();
//        //.orElse(3);
//        System.out.println(firstSquareDivisibleByThree);
//
//        int product = numbers.stream().reduce(1, (a, b) -> a * b);
//        int sum = numbers.stream().reduce(1, Integer::sum);
//        System.out.println(product);
//        System.out.println(sum);
//
//        Optional<Integer> max = numbers.stream().reduce(Integer::max);
//        System.out.println(max.get());
//
//        System.out.println(numbers.stream().count());
//
//        System.out.println(numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
//
//        System.out.println(numbers.stream().collect(Collectors.toMap(Function.identity(), iterate -> 1, Math::addExact)));
//
//        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
//        System.out.println(calories);
//
//
//        Stream<String> stream = Stream.of("Java", "Spring");
//        System.out.println(stream.collect(Collectors.toList()));
//
//        int[] arr = {2,3,4,5,6};
//        int sumArr = Arrays.stream(arr).sum();
//        System.out.println(sumArr);
//
//        long uniqueWords = 0;
//        try(Stream<String> lines = Files.lines(Paths.get("data.txt"))){
//            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
//                    .distinct()
//                    .filter(w -> {
//                        System.out.println(w);
//                        return true;
//                    })
//                    .count();
//        } catch (IOException e) {
//
//        }
//        System.out.println(uniqueWords);
//
//
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);
//
//        Stream.generate(Math::random)
//                .limit(5)
//                .forEach(System.out::println);
//
//        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
//        System.out.println(shortMenu);
//
//        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
//        System.out.println(totalCalories);


    }

}

class Dish {

    private int calories;
    private boolean isVegetarian;

    private String name;

    public Dish() {
    }

    public Dish(int calories, boolean isVegetarian, String name) {
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                ", name='" + name + '\'' +
                '}';
    }
}
