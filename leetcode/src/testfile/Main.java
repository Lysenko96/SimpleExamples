package testfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Org> orgs = new ArrayList<>();
        orgs.add(null);
        orgs.add(new Org("name"));
        orgs.add(new Org("name2"));
        for(Org o : orgs) {
            System.out.println("IDF" + new Date() + "-" + (o != null ? o.getName() : ""));
        }
        try {
            File f = new File("file2.txt");
            if (f.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("file2.txt"));
                writer.write("TEXT" + "\t" + System.lineSeparator());
                for (Org o : orgs) {
                    if (o != null)
                        writer.write(o.getName());
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Org {
    private String name;

    public Org(String name) {
        this.name = name;
    }

    public Org() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
