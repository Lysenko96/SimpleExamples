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
            start.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void read() throws Exception {
        // 1. Open a FileChannel
        RandomAccessFile aFile = new RandomAccessFile(new File("/home/user/Documents/readwritenio/src/main/resources/test"), "rw");
        FileChannel inChannel = aFile.getChannel();

        // 2. Create a ByteBuffer
        ByteBuffer buf = ByteBuffer.allocate(1024); // Allocate a 1024-byte buffer

        int bytesRead = inChannel.read(buf); // 3. Read data from channel into buffer

        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead + " bytes");
            buf.flip();  // 4. Flip the buffer to prepare for reading from it

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // Read byte by byte from buffer
            }

            buf.clear(); // 5. Clear the buffer to prepare for writing into it again
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    public void write() {
        // The data we want to write to the file
        String data = "Hello, Java NIO Channels! This is a writing demonstration.";

        try (
                // 1. Open a RandomAccessFile in read/write mode ("rw").
                // Using try-with-resources ensures the file and channel are closed automatically.
                RandomAccessFile file = new RandomAccessFile("/home/user/Documents/readwritenio/src/main/resources/result", "rw");
                FileChannel channel = file.getChannel()
        ) {
            // 2. Wrap the String data into a ByteBuffer
            // We use StandardCharsets.UTF_8 to convert the String to bytes.
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));

            // 3. Write the buffer content to the channel
            // The write() method takes data from the buffer's current position to its limit.
            int bytesWritten = channel.write(buffer);

            // 4. Print confirmation
            System.out.println("Successfully wrote data to output.txt.");
            System.out.println("Total bytes written: " + bytesWritten);

            // 5. Ensure any pending writes are forced to the device (optional but good practice)
            channel.force(true);

        } catch (Exception e) {
            System.err.println("An error occurred during file channel write operation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
