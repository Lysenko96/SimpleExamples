package ua.com.systemgroup.dockerdatabaseserverprovider.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Component
public class ParseUtil<E> {

    public static final String BACKUP_EXTENSION = ".bak";
    public static final String CSV_EXTENSION = ".csv";

    private final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    private final DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSSSSS");
    private final DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss.SSSSSS");
    private final DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm");
    private final DateTimeFormatter formatterZ1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
    private final DateTimeFormatter formatterZ2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    private final DateTimeFormatter formatterZ3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
    private final DateTimeFormatter formatterZ4 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmX");
    private final DateTimeFormatter formatterZ5 = DateTimeFormatter.ofPattern("HH:mm:ss XXXXX");
    private final DateTimeFormatter formatterZ6 = DateTimeFormatter.ofPattern("HH:mm:ssX");

    private final DateTimeFormatter formatterZoneTime =  new DateTimeFormatterBuilder()
            .appendOptional(formatterZ5)
            .appendOptional(formatterZ6)
            .toFormatter();

    private final DateTimeFormatter formatterZoneDateTime = new DateTimeFormatterBuilder()
            .appendOptional(formatterZ1)
            .appendOptional(formatterZ2)
            .appendOptional(formatterZ3)
            .appendOptional(formatterZ4)
            .toFormatter();

    private final DateTimeFormatter formatterLocalDateTime = new DateTimeFormatterBuilder()
            .appendOptional(formatter4)
            .appendOptional(formatter5)
            .toFormatter();

    public Object parseType(Class<?> clazz, String param) {

        if (param == null || param.equalsIgnoreCase("null") || param.isEmpty()) return null;

        Object result = null;
        if (clazz == Short.class) {
            result = Short.parseShort(param);
        } else if (clazz == Integer.class) {
            result = Integer.parseInt(param);
        } else if (clazz == Long.class) {
            result = Long.parseLong(param);
        } else if (clazz == Float.class) {
            result = Float.parseFloat(param);
        } else if (clazz == Double.class) {
            result = Double.parseDouble(param);
        } else if (clazz == Boolean.class) {
            result = Boolean.parseBoolean(param);
        } else if (clazz == Byte.class) {
            result = Byte.parseByte(param);
        } else if (clazz == Character.class) {
            result = param.charAt(0);
        } else if (clazz == String.class) {
            result = param;
        } else if (clazz == String[].class) {
            String[] params = getParams(param);
            String[] arr = (String[]) Array.newInstance(String.class, params.length);
            result = parseTypeArray(String.class, arr, params);
        } else if (clazz == UUID.class) {
            result = UUID.fromString(param);
        } else if (clazz == BigDecimal.class) {
            result = new BigDecimal(param);
        } else if (clazz == BigDecimal[].class) {
            String[] params = getParams(param);
            BigDecimal[] arr = (BigDecimal[]) Array.newInstance(BigDecimal.class, params.length);
            result = parseTypeArray(clazz, arr, params);
        } else if (clazz == Integer[].class) {
            String[] params = getParams(param);
            Integer[] arr = (Integer[]) Array.newInstance(Integer.class, params.length);
            result = parseTypeArray(clazz, arr, params);
        } else if (clazz == Date.class) {
            result = parseDate(param);
        } else if (clazz == LocalDateTime.class) {
            result = LocalDateTime.parse(param, formatter3);
        } else if (clazz == OffsetTime.class) {
            result = OffsetTime.parse(param, formatterZoneTime);
        }

        return result;
    }

    public Date parseDate(String date) {

        return Date.from(LocalDate.parse(date, formatter1)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public Object[] parseTypeArray(Class<?> clazz, Object[] arr, String[] params) {
        for (int i = 0; i < params.length; i++) {
            if (clazz == BigDecimal[].class) {
                arr[i] = new BigDecimal(params[i].trim());
            } else if (clazz == Integer[].class) {
                arr[i] = Integer.parseInt(params[i].trim());
            } else if (clazz == String.class) {
                arr[i] = params[i].trim();
            }
        }

        return arr;
    }

    public Object parseArrayToString(Field nameField, E entity) throws IllegalAccessException {
        String integerArrayStr = Arrays.toString((Number[]) nameField.get(entity)).replace("[", "{").replace("]", "}");
        Class<?> type = String.class;

        return parseType(type, integerArrayStr);
    }

    public String parseDataToString(Field nameField, E entity, Class<?> clazz) throws IllegalAccessException {
        if(nameField.get(entity) == null) return null;

        Object data = Objects.requireNonNull(nameField.get(entity));
        Object result = null;

        if (clazz.equals(Date.class)) {
            result = LocalDate.parse(String.valueOf(data), formatter2);
        } else if (clazz.equals(ZonedDateTime.class)) {
            result = ZonedDateTime.parse(String.valueOf(data), formatterZoneDateTime);
        } else if (clazz.equals(LocalDateTime.class)) {
            result = LocalDateTime.parse(String.valueOf(data), formatterLocalDateTime);
        }

        return String.valueOf(result);
    }

    private String[] getParams(String param) {
        return param.replace("{", "").replace("}", "").split(",");
    }

}
