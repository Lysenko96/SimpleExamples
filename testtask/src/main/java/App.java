import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        List<String> result = new ArrayList<>();

//        System.out.println(new File(App.class.getProtectionDomain().getCodeSource().getLocation()
//                .toURI()).getPath());

        String path = App.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI().getPath();

//        java.util.jar.JarFile jar = new java.util.jar.JarFile(path + File.separator + "testtask-1.0-SNAPSHOT-jar-with-dependencies.jar");
//        java.util.Enumeration enumEntries = jar.entries();
//        while (enumEntries.hasMoreElements()) {
//            java.util.jar.JarEntry file = (java.util.jar.JarEntry) enumEntries.nextElement();
//            java.io.File f = new java.io.File(file.getName());
////            System.out.println(f);
//            if (file.isDirectory()) { // if its a directory, create it
//                f.mkdir();
//                continue;
//            }
//            if(file.getName().equals("input.txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
                    List<String> lines = reader.lines().toList();
                    lines.forEach(System.out::println);
                    String length = lines.get(0).split(" ")[0];
                    String queryCounter = lines.get(0).split(" ")[1];
                    String s = lines.get(1);
                    List<String> queries = lines.subList(2, lines.size());
                    List<Tuple> tuples = new ArrayList<>();
                    queries.forEach(q ->
                            tuples.add(new Tuple(Integer.parseInt(q.split(" ")[0]),
                                    Integer.parseInt(q.split(" ")[1]),
                                    Integer.parseInt(q.split(" ")[2])))
                    );
//            System.out.println(tuples);
//            System.out.println(s);
                    for (Tuple t : tuples) {
                        String sub = s.substring(t.getL() - 1, t.getR());
//                System.out.println(sub);
                        String k = String.valueOf(sub.charAt(t.getK() - 1));
//                System.out.println(k);
                        int counter = 0;
                        for (String ch : sub.substring(0, t.getK()).split("")) {
                            if (ch.equals(k)) counter++;
                        }
//                System.out.println(counter);
                        String search = null;
                        if (k.equals("A")) search = "B";
                        else if (k.equals("B")) search = "A";

                        List<Integer> idxs = new ArrayList<>();
                        int idx = 1;
                        for (String ch : sub.split("")) {
                            if (ch.equals(search)) idxs.add(idx);
                            idx++;
                        }
//                System.out.println(idxs);
                        String line = null;
                        if (idxs.size() < counter) line = "-1";
                        else line = String.valueOf(idxs.get(counter - 1));
//                System.out.println(line);
                        result.add(line);

                    }
                    try (FileWriter fw = new FileWriter("output.txt")) {
                        for (String line : result) fw.write(line + System.lineSeparator());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

//            java.io.InputStream is = jar.getInputStream(file); // get the input stream
//            java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
//            while (is.available() > 0) {  // write contents of 'is' to 'fos'
//                fos.write(is.read());
//            }
//            fos.close();
//            is.close();
//        }
//        jar.close();
//    }
}
