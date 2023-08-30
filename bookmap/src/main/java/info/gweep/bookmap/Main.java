package info.gweep.bookmap;

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
import java.util.Objects;
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
                        //System.out.println(items.stream().filter(item -> item.getPrice() == Integer.parseInt(arrItem[2])).findFirst().orElse(null));
                    }

                } else if (arrLines[i].startsWith("o")) {
                    if (arrItem[1].contains("buy")) {
                        Item it = items.stream().filter(item -> item.getTransactionType().contains("ask")).min(Comparator.comparing(Item::getPrice)).orElse(null);
                        //System.out.println(it);
                        if (it != null) it.setSize(it.getSize()-1);
                        //System.out.println(it);
                        //if (it != null) items.remove(it);
                    } else if (arrItem[1].contains("sell")) {
                        Item it = items.stream().filter(item -> item.getTransactionType().contains("bid")).max(Comparator.comparing(Item::getPrice)).orElse(null);
                        //System.out.println(it);
                        if (it != null) it.setSize(it.getSize()-1);
                        //System.out.println(it);
                        //if (it != null) items.remove(it);
                    }
                   // items.add(new OrderItem(arrItem[0], arrItem[1], Integer.parseInt(arrItem[2])));
                }
            }
           // items.stream().forEach(System.out::println);
            FileWriter fileWriter = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(result.toString());
            printWriter.close();
            System.out.println(result);
            lines.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class OrderItem implements Item {


    private String typeQuery;
    private String transactionType;
    private int size;

    public OrderItem() {
    }

    public OrderItem(String typeQuery, String transactionType, int size) {
        this.typeQuery = typeQuery;
        this.transactionType = transactionType;
        this.size = size;
    }

    @Override
    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (size != orderItem.size) return false;
        if (!Objects.equals(typeQuery, orderItem.typeQuery)) return false;
        return Objects.equals(transactionType, orderItem.transactionType);
    }

    @Override
    public int hashCode() {
        int result = typeQuery != null ? typeQuery.hashCode() : 0;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "typeQuery='" + typeQuery + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", size=" + size +
                '}';
    }
}

class QueryItem implements Item {

    private String typeQuery;
    private int price;
    private int size;
    private String transactionType;

    public QueryItem() {
    }

    public QueryItem(String typeQuery, int price, int size, String transactionType) {
        this.typeQuery = typeQuery;
        this.price = price;
        this.size = size;
        this.transactionType = transactionType;
    }

    public QueryItem(String typeQuery, String transactionType) {
        this.typeQuery = typeQuery;
        this.transactionType = transactionType;
    }

    public QueryItem(String typeQuery, String transactionType, int price) {
        this.typeQuery = typeQuery;
        this.transactionType = transactionType;
        this.price = price;
    }

    @Override
    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryItem queryItem = (QueryItem) o;

        if (price != queryItem.price) return false;
        if (size != queryItem.size) return false;
        if (!Objects.equals(typeQuery, queryItem.typeQuery)) return false;
        return Objects.equals(transactionType, queryItem.transactionType);
    }

    @Override
    public int hashCode() {
        int result = typeQuery != null ? typeQuery.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + size;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QueryItem{" +
                "typeQuery='" + typeQuery + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}

class UpdateItem implements Item {

    private String typeQuery;
    private int price;
    private int size;
    private String transactionType;

    public UpdateItem() {
    }

    public UpdateItem(String typeQuery, int price, int size, String transactionType) {
        this.typeQuery = typeQuery;
        this.price = price;
        this.size = size;
        this.transactionType = transactionType;
    }

    @Override
    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateItem that = (UpdateItem) o;

        if (price != that.price) return false;
        if (size != that.size) return false;
        if (!Objects.equals(typeQuery, that.typeQuery)) return false;
        return Objects.equals(transactionType, that.transactionType);
    }

    @Override
    public int hashCode() {
        int result = typeQuery != null ? typeQuery.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + size;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateItem{" +
                "typeQuery='" + typeQuery + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}

interface Item {


    String getTypeQuery();

    int getSize();

    int getPrice();

    String getTransactionType();

    void setSize(int size);


}