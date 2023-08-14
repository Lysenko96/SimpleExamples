package info.gweep.bookmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();

        Stream<String> lines = null;
        StringBuilder result = new StringBuilder();
        try {
            //System.out.println(System.getProperty("user.dir")  + File.separator + "input.txt");
            Path path = Paths.get(System.getProperty("user.dir")  + File.separator + "input.txt");
            lines = Files.lines(path);
            Stream<String> linesCounter = Files.lines(path);
            long counter = linesCounter.count();
            String data = lines.collect(Collectors.joining(System.lineSeparator()));
            String[] arrLines = data.split(System.lineSeparator());
            for (int i = 0; i < counter; i++) {
               // System.out.println(arrLines[i]);
                String[] arrItem = arrLines[i].split(",");
                if (arrLines[i].startsWith("u")) {
                    items.add(new UpdateItem(arrItem[0], Integer.parseInt(arrItem[1]), Integer.parseInt(arrItem[2]), arrItem[3]));
                } else if (arrLines[i].startsWith("q")) {

                    if (arrItem.length == 2) {
                        if (arrItem[1].contains("best_bid")) {
                            Item it = items.stream().filter(item -> item.getTransactionType().contains("bid")).max(Comparator.comparing(Item::getPrice).thenComparing(Item::getSize)).orElse(null);
                            if (it != null) {
                                //System.out.println(it.getPrice() + "," + it.getSize());
                                result.append(it.getPrice()).append(",").append(it.getSize()).append(System.lineSeparator());
                            }
                        } else if (arrItem[1].contains("best_ask")) {
                            Item it = items.stream().filter(item -> item.getTransactionType().contains("ask")).max(Comparator.comparing(Item::getPrice).thenComparing(Item::getSize)).orElse(null);
                            if (it != null) {
                                //System.out.println(it.getPrice() + "," + it.getSize());
                                result.append(it.getPrice()).append(",").append(it.getSize()).append(System.lineSeparator());
                            }
                        }
                        //items.add(new QueryItem(arrItem[0], arrItem[1]));
                    } else {
                        //items.add(new QueryItem(arrItem[0], arrItem[1], Integer.parseInt(arrItem[2])));
                        //System.out.println(items.stream().filter(item -> item.getPrice() == Integer.parseInt(arrItem[2])).count());
                        result.append(items.stream().filter(item -> item.getPrice() == Integer.parseInt(arrItem[2])).count()).append(System.lineSeparator());
                    }

                } else if (arrLines[i].startsWith("o")) {
                    if (arrItem[1].contains("buy")) {
                        Item it = items.stream().filter(item -> item.getTransactionType().contains("ask") && item.getSize() == Integer.parseInt(arrItem[2])).min(Comparator.comparing(Item::getPrice)).orElse(null);
                        if (it != null) items.remove(it);
                    } else if (arrItem[1].contains("sell")) {
                        Item it = items.stream().filter(item -> item.getTransactionType().contains("bid") && item.getSize() == Integer.parseInt(arrItem[2])).max(Comparator.comparing(Item::getPrice)).orElse(null);
                        if (it != null) items.remove(it);
                    }
                   // items.add(new OrderItem(arrItem[0], arrItem[1], Integer.parseInt(arrItem[2])));
                }
            }
           // items.stream().forEach(System.out::println);
            FileWriter fileWriter = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(result.toString());
            printWriter.close();
            //System.out.println(result);
            lines.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class OrderItem implements Item {


    private String typeQuery;
    private String transactionType;
    private int size;

    @Override
    public int getPrice() {
        return 0;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class QueryItem implements Item {

    private String typeQuery;
    private int price;
    private int size;
    private String transactionType;

    public QueryItem(String typeQuery, String transactionType) {
        this.typeQuery = typeQuery;
        this.transactionType = transactionType;
    }

    public QueryItem(String typeQuery, String transactionType, int price) {
        this.typeQuery = typeQuery;
        this.transactionType = transactionType;
        this.price = price;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class UpdateItem implements Item {

    private String typeQuery;
    private int price;
    private int size;
    private String transactionType;

}

interface Item {


    String getTypeQuery();

    int getSize();

    int getPrice();

    String getTransactionType();


}