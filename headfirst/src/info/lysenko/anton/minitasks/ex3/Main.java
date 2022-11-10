package info.lysenko.anton.minitasks.ex3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.readFromFile(true, 2));
//        System.out.println();
//        System.out.println(main.readFromFile(false, 10));

    }

    private Data readFromFile(boolean up, int counter) {
        StringBuilder result = new StringBuilder();
        int symbols = 0;
        int wordsCounter = 0;
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/user/Documents/Spd/headfirst/song1.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //result.append(line).append(System.lineSeparator());
                String[] words = line.split(" ");
                wordsCounter += words.length;
                for(String letter : words){
                    //System.out.println(letter);
                    char[] characters = letter.toCharArray();
                    for(char ch : characters) {
                        if (Character.isLetterOrDigit(ch)) {
                            //System.out.println(ch);
                            symbols++;
                        }
                    }
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(up) {
            for(int i = 0; i < counter; i++)
                result.append(lines.get(i)).append(System.lineSeparator());
        } else {
            Collections.reverse(lines);
            for(int i = 0; i < counter; i++)
                result.append(lines.get(i)).append(System.lineSeparator());
        }
        //System.out.println(result);
        //return result.toString();

        return new Data(lines.size(),wordsCounter,symbols);
    }
}

class Data {

    private int lines;
    private int words;
    private int symbols;

    public Data(int lines, int words, int symbols) {
        this.lines = lines;
        this.words = words;
        this.symbols = symbols;
    }

    public int getLines() {
        return lines;
    }

    public int getWords() {
        return words;
    }

    public int getSymbols() {
        return symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return lines == data.lines && words == data.words && symbols == data.symbols;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, words, symbols);
    }

    @Override
    public String toString() {
        return "Data{" +
                "lines=" + lines +
                ", words=" + words +
                ", symbols=" + symbols +
                '}';
    }
}
