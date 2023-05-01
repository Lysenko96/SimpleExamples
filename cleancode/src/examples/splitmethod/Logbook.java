package examples.splitmethod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Logbook {

    static final Path CREW_LOG = Paths.get("/var/log/crew.log");

    List<String> readEntries(LocalDate date) throws IOException {
        Objects.requireNonNull(date);
        final List<String> result = new LinkedList<>();
        for (String entry : readAllEntries())
            result.add(entry);

        return result;
    }

    List<String> readAllEntries() throws IOException {
        return Files.readAllLines(CREW_LOG, StandardCharsets.UTF_8);
    }
}
