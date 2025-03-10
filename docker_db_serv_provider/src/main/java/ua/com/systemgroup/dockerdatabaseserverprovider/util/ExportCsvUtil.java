package ua.com.systemgroup.dockerdatabaseserverprovider.util;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import static ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil.CSV_EXTENSION;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExportCsvUtil<E, PK> {


    @Value("${custom.path}")
    private String path;
    @Value("${custom.delimiter}")
    private Character delimiter;

    private final ParseUtil<E> parseUtil;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");

    @Transactional(readOnly = true)
    public List<Object[]> findListEntityByRepository(JpaRepository<E, PK> jpaRepository, Class<E> clazz) {
        List<E> entities = jpaRepository.findAll();
        List<Object[]> argsList = new ArrayList<>();

        for (E entity : entities) {
            Field[] entityFields = clazz.getDeclaredFields();
            Class<?>[] types = new Class<?>[entityFields.length];
            Object[] args = new Object[entityFields.length];

            try {
                for (int i = 0; i < entityFields.length; i++) {
                    Field field = entityFields[i];
                    Field nameField = clazz.getDeclaredField(field.getName());
                    nameField.setAccessible(true);
                    types[i] = field.getType();

                    if (types[i].equals(Date.class)) {
                        args[i] = parseUtil.parseDataToString(nameField, entity, Date.class);
                    } else if (types[i].equals(LocalDateTime.class)) {
                        args[i] = parseUtil.parseDataToString(nameField, entity, LocalDateTime.class);
                    } else if (types[i].equals(ZonedDateTime.class)) {
                        args[i] = parseUtil.parseDataToString(nameField, entity, ZonedDateTime.class);
                    } else if (types[i].equals(BigDecimal[].class)) {
                        args[i] = parseUtil.parseArrayToString(nameField, entity);
                    } else if (types[i].equals(Integer[].class)) {
                        args[i] = parseUtil.parseArrayToString(nameField, entity);
                    } else {
                        args[i] = parseUtil.parseType(types[i], String.valueOf(nameField.get(entity)));
                    }
                }

                argsList.add(args);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.error("Error while find list entity by repository");
                throw new RuntimeException(e);
            }
        }

        return argsList;
    }

    public void writeToFile(List<Object[]> argsList, String fileName) {
        try {
            File file = new File(path + File.separator + formatter.format(LocalDateTime.now()) + "_" + fileName + CSV_EXTENSION);

            if (file.exists()) {
                Files.delete(file.toPath());
            }

            CSVWriterBuilder csvWriterBuilder = new CSVWriterBuilder(new FileWriter(file));
            csvWriterBuilder.withSeparator(delimiter);

            try (ICSVWriter writer = csvWriterBuilder.build()) {
                for (Object[] line : argsList) {
                    String[] argsArr = Arrays.stream(line)
                            .map(arg -> Objects.requireNonNullElse(arg, ""))
                            .map(String::valueOf)
                            .map(arg -> arg.equalsIgnoreCase("") ? null : arg)
                            .toArray(String[]::new);

                    writer.writeNext(argsArr);
                }
            }
        } catch (IOException e) {
            log.error("Error writing to file", e);
            throw new RuntimeException(e);
        }
    }
}
