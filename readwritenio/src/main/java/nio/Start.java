package nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Start {

    public static void main(String[] args) {
        Start start = new Start();
        try {
            start.read();
            System.out.println();
            start.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void read() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile(new File("/home/user/Documents/readwritenio/src/main/resources/test"), "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    public void write() {
        String data = "Hello, Java NIO Channels! This is a writing demonstration.";
        try (RandomAccessFile file = new RandomAccessFile("/home/user/Documents/readwritenio/src/main/resources/result", "rw");
             FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));
            int bytesWritten = channel.write(buffer);
            System.out.println("Successfully wrote data to result.");
            System.out.println("Total bytes written: " + bytesWritten);
            channel.force(true);
        } catch (Exception e) {
            System.err.println("An error occurred during file channel write operation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
