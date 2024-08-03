package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
         URL url = new URL("https://jsonmock.hackerrank.com/api/inventory?barcode=" + 74001755);
        URLConnection con = url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        String jsonStr = sb.toString();

        Long price = 0L;
        Long discount = 0L;

        JSONObject o = (JSONObject) new JSONParser().parse(jsonStr);
        JSONArray jsonArray = (JSONArray) o.get("data");
    for(Object i : jsonArray) {
        price = (Long) ((JSONObject)i).get("price");
        discount = (Long) ((JSONObject)i).get("discount");
    }

        System.out.println(price);
        System.out.println(discount);

        System.out.println(price / discount);
    }
}

abstract class Car {

    protected boolean isSedan;
    protected String seats;
    protected String mileage;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
        String.valueOf(1);
    }

    public boolean getIsSedan() {return isSedan;};
    public String getSeats() {return seats;};
    public abstract String getMileage();
}

class WagonR extends Car {


    public WagonR() {
        super(false, "4");
    }

    public WagonR(String mileage) {
        this();
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage;
    }
}

class HondaCity extends Car {

    public HondaCity() {
        super(true, "4");
    }

    public HondaCity(String mileage) {
        this();
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage;
    }
}

class InnovaCrysta extends Car {

    public InnovaCrysta() {
        super(false, "6");
    }

    public InnovaCrysta(String mileage) {
        this();
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage;
    }
}
