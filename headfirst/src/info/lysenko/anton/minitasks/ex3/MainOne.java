package info.lysenko.anton.minitasks.ex3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainOne {

    List<String> list = new ArrayList<>();
    File currentDir = new File("/home/user/Documents/Spd/headfirst/src/info/lysenko/anton/minitasks/ex3");
    String[] files;

    public static void main(String[] args) {
        MainOne mainOne = new MainOne();
        mainOne.up();
        mainOne.itemStateChanged();
    }

    protected void up(){
        String parent = currentDir.getParent();
        if(parent == null) return;
        listDirectory(parent);
    }

    public void listDirectory(String directory){
        File dir = new File(directory);
        if(dir.isDirectory()) {
            files = dir.list();
        }
        if(files != null) {
            Arrays.sort(files);

            list.add("[Up to Parent Directory");
            list.addAll(Arrays.asList(files));
            System.out.println(list);
            currentDir = dir;
        }
    }

    public void itemStateChanged(){
        int i = list.size() - 1;
        if(i < 0) return;
        for(int j = 0; j < i; j++) {
            String filename = files[j];
            File f = new File(currentDir, filename);
            if (f.exists()) {
                String info = filename;
                if (f.isDirectory())
                    info += File.separator;
                info += " " + f.length() + " bite ";
                info += new Date(f.lastModified());
                if (f.canRead()) info += " for reading";
                if (f.canWrite()) info += " for writing";
                System.out.println(info);
            }
        }
    }
}
