package examples.avoidnpeconditionals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;

public class Logbook {

    void writeMessage(String message, Path location) throws IOException {
        if(message == null || message.trim().isEmpty()){
            throw new IllegalArgumentException("The message is invalid!");
        }
        if(location == null || Files.isDirectory(location)){
            throw new IllegalArgumentException("The path is invalid!");
        }
        String entry = LocalDate.now() + ": " + message;
        Files.write(location, Collections.singletonList(entry), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
