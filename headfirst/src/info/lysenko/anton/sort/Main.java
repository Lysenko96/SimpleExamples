package info.lysenko.anton.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    Set<Song> songList = new HashSet<>();

    public static void main(String[] args) {
        List<A> a = new ArrayList<>();
        List<C> b = new ArrayList<>();
        a.add(new B());
        Main m = new Main();
//        m.take(a);
//        m.take(b);
        List<Song> songs = new ArrayList<>(m.getSongs());
        System.out.println(songs);
        songs.sort(Comparator.comparing(Song::getArtist));
        //System.out.println(songs);
        songs.sort(new ArtistCompare());
        System.out.println(songs);
        Collections.sort(songs);
        System.out.println(songs);
    }

    public Set<Song> getSongs(){
        try {
            File file = new File("/home/user/Documents/Spd/headfirst/song.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] tokens = line.split("/");
               // String name = tokens[1].split(" ")[0].isEmpty() ? null : tokens[1].split(" ")[0];
                //if(name != null)
                    //songList.add(new Song(tokens[0], tokens[1].split(" ")[0].isEmpty() ? null : tokens[1].split(" ")[0] ,tokens[2],tokens[3]));
                    songList.add(new Song(tokens[0], tokens[1],tokens[2],tokens[3]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songList;
    }

    public <T extends C> void take(Set<T> list){
        System.out.println(list);
    }
}

class Song implements Comparable<Song> {

    String title;
    String artist;
    String rating;
    String bpm;

    Song(String title, String artist, String rating, String bpm){
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getRating(){
        return rating;
    }

    public String getBpm(){
        return bpm;
    }

    @Override
    public int compareTo(Song o) {
        return title.compareTo(o.getTitle());
    }

    @Override
    public String toString(){
        return "title: " + title + " artist: " + artist;
    }



}

class ArtistCompare implements Comparator<Song> {
    @Override
    public int compare(Song song, Song t1) {
        return song.getArtist().compareTo(t1.getArtist());
    }
}

class A implements C {

}

class B extends A {

}

interface C {

}
