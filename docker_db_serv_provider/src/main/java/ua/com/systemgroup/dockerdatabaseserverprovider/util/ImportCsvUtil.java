package ua.com.systemgroup.dockerdatabaseserverprovider.util;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import static ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil.BACKUP_EXTENSION;
import static ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil.CSV_EXTENSION;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImportCsvUtil<E, PK> {

    @Value("${custom.path}")
    private String path;
    @Value("${custom.delimiter}")
    private Character delimiter;
    @Value("${custom.import.encoding}")
    private String encoding;
    @Value("${custom.import.idShop}")
    private String idShop;
    @Value("${custom.import.idParentGroup}")
    private String idParentGroup;
    @Value("${custom.import.signActivity}")
    private String signActivity;
    @Value("${custom.import.idMaker}")
    private String idMaker;
    @Value("${custom.import.idDepartment}")
    private String idDepartment;
    @Value("${custom.import.dtype}")
    private String dtype;
    @Value("${custom.import.vatGroup}")
    private String vatGroup;
    @Value("${custom.import.saleInTara}")
    private String saleInTara;
    @Value("${custom.import.active}")
    private String active;
    @Value("${custom.import.fiscal}")
    private String fiscal;
    @Value("${custom.import.local}")
    private String local;
    @Value("${custom.import.printer}")
    private String printer;
    @Value("${custom.import.isExcise}")
    private String isExcise;
    @Value("${custom.import.idMeasure}")
    private String idMeasure;
    @Value("${custom.import.signFindBarcode}")
    private String signFindBarcode;
    private final ParseUtil<?> parseUtil;

    public List<E> findListEntityFromCSVByType(Class<E> clazz, String fileName) {

        List<E> entities = new ArrayList<>();
        String filePath = path + File.separator + fileName;

        try {
            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder((new FileReader(filePath, Charset.forName(encoding))));
            ICSVParser parser = new CSVParserBuilder().withSeparator(delimiter).build();
            csvReaderBuilder.withCSVParser(parser);

            try (CSVReader reader = csvReaderBuilder.build()) {
                String[] param;

                while ((param = reader.readNext()) != null) {
                    Field[] entityFields = clazz.getDeclaredFields();
                    Class<?>[] types = new Class<?>[param.length];
                    Object[] args = new Object[param.length];

                    for (int i = 0; i < param.length; i++) {
                        Field field = entityFields[i];
                        types[i] = field.getType();
                        if (fileName.equals("t_articles_group" + CSV_EXTENSION)) {
                            switch (field.getName()) {
                                case "idShop" -> args[i] = Short.valueOf(idShop);
                                case "idParentGroup" -> args[i] = Integer.valueOf(idParentGroup);
                                case "signActivity" -> args[i] = Boolean.valueOf(signActivity);
                                default -> args[i] = parseUtil.parseType(types[i], param[i]);
                            }
                        } else if (fileName.equals("t_article" + CSV_EXTENSION)) {
                            switch (field.getName()) {
                                case "idShop" -> args[i] = Short.valueOf(idShop);
                                case "idMaker" -> args[i] = Integer.valueOf(idMaker);
                                case "idDepartment" -> args[i] = Integer.valueOf(idDepartment);
                                case "sname" -> args[i] = ((String) args[i-1]).length() > 64 ?
                                        ((String) args[i-1]).substring(0, 64) : ((String) args[i-1]);
                                case "dtype" -> args[i] = Short.valueOf(dtype);
                                case "vatGroup" -> args[i] = vatGroup;
                                case "saleInTara" -> args[i] = Boolean.valueOf(saleInTara);
                                case "active" -> args[i] = Boolean.valueOf(active);
                                case "fiscal" -> args[i] = Boolean.valueOf(fiscal);
                                case "local" -> args[i] = Boolean.valueOf(local);
                                case "printer" -> args[i] = Integer.valueOf(printer);
                                case "isExcise" -> args[i] = Integer.valueOf(isExcise);
                                default -> args[i] = parseUtil.parseType(types[i], param[i]);
                            }
                        } else if (fileName.equals("t_barcode" + CSV_EXTENSION)) {
                            switch (field.getName()) {
                                case "idShop" -> args[i] = Short.valueOf(idShop);
                                case "idMeasure" -> args[i] = Integer.valueOf(idMeasure);
                                case "signFindBarcode" -> args[i] = Short.valueOf(signFindBarcode);
                                case "dtype" -> args[i] = Short.valueOf(dtype);
                                case "addField", "expirationDates" -> args[i] = null;
                                default -> args[i] = parseUtil.parseType(types[i], param[i]);
                            }
                        } else {
                            args[i] = parseUtil.parseType(types[i], param[i]);
                        }
                    }

                    Constructor<E> constructor = clazz.getConstructor(types);
                    E entity = constructor.newInstance(args);
                    entities.add(entity);
                }

            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                     IllegalAccessException e) {
                log.error("Error while reading csv file", e);
                throw new RuntimeException(e);
            }

        } catch (IOException | CsvValidationException e) {
            log.error("Error while reading csv file", e);
            throw new RuntimeException(e);
        }

        return entities;
    }

    @Transactional
    public void saveAll(JpaRepository<E, PK> jpaRepository, List<E> entities) {
        jpaRepository.saveAll(entities);
    }

    public String[] getFileNames(FilenameFilter filenameFilter) {
        File csvDir = new File(path);

        if (!Files.exists(csvDir.toPath())) {
            try {
                Files.createDirectory(csvDir.toPath());
            } catch (IOException e) {
                log.error("Error while creating file", e);
                throw new RuntimeException(e);
            }
        }

        return Objects.requireNonNull(csvDir.list(filenameFilter));
    }

    public void renameFile(String fileName) {
        String filePath = path + File.separator + fileName;
        Path backupPath = Paths.get(path + File.separator + "backup");

        if (!fileName.endsWith(BACKUP_EXTENSION)) {
            Path sourcePath = Paths.get(filePath);

            try {
                if (!Files.exists(backupPath)) Files.createDirectory(backupPath);
                Path targetPath = Paths.get(backupPath + File.separator + fileName + BACKUP_EXTENSION);

                if (!Files.exists(targetPath)) {
                    Files.move(sourcePath, targetPath);
                } else if (Files.exists(targetPath)) {
                    Files.delete(targetPath);
                    Files.move(sourcePath, targetPath);
                }
            } catch (IOException e) {
                log.error("Error while renaming file", e);
                throw new RuntimeException(e);
            }
        }
    }

}
