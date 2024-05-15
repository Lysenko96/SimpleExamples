package org.example.storagespringboot.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {

    public static byte[] compress(byte[] bytes) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(bytes);
        deflater.finish();

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length)) {
            byte[] buffer = new byte[4096];
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decompress(byte[] bytes) {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length)) {
            byte[] buffer = new byte[4096];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
