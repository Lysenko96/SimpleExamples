package com.example.springiocdemo;

import javassist.bytecode.ByteArray;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;

public class StartupApplication implements Serializable {

    public static void main(String[] args) throws IOException {
//        CustomContext context = new CustomContext();
//        CustomBean customBean = context.getBean(CustomBean.class);
//        customBean.printCustomBean();
//        @RestController
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("/home/user/Documents/feature_21013"));
//            br.lines().forEach(System.out::println);
//            BufferedWriter wr = new BufferedWriter(new FileWriter("/home/user/Documents/feature_21013"));
//            wr.write("write");
//            wr.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Writer w;
//        Stack s;
//        ArrayDeque d;
//        ApplicationContext context1 = new AnnotationConfigApplicationContext(Config.class);
//        Client client = context1.getBean("client", Client.class);
//        System.out.println(client);
//        try {
//            OutputStream os = new FileOutputStream("/home/user/Documents/SimpleExamples/spring-ioc-demo/src/main/webapp/1.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(os));
//            oos.writeObject(new Test());
//            oos.flush();
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/user/Documents/SimpleExamples/spring-ioc-demo/src/main/webapp/1.txt"));
//            System.out.println((Test)ois.readObject());
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        Pipe p;
//        RandomAccessFile aFile = null;
//        try {
//            aFile = new RandomAccessFile("/home/user/nio-data.txt", "rw");
//            FileChannel inChannel = aFile.getChannel();
//
////create buffer with capacity of 48 bytes
//            ByteBuffer buf = ByteBuffer.allocate(48);
//
//            int bytesRead = inChannel.read(buf); //read into buffer.
//            while (bytesRead != -1) {
//
//                buf.flip();  //make buffer ready for read
//
//                while (buf.hasRemaining()) {
//                    System.out.print((char) buf.get()); // read 1 byte at a time
//                }
//
//                buf.clear(); //make buffer ready for writing
//                bytesRead = inChannel.read(buf);
//            }
//            aFile.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
      new StartupApplication().selector();
      Map m = new HashMap(16);
      new ArrayList<>(16);
      ArrayList a;
      LinkedList l;
        Instant i;
        Duration d;
    }

    void selector() throws IOException {
//        Selector selector = Selector.open();
//        RandomAccessFile aFile = new RandomAccessFile("/home/user/nio-data.txt", "rw");
//        ServerSocketChannel channel = ServerSocketChannel.open();
//        channel.bind(new InetSocketAddress("localhost", 5454));
//        channel.configureBlocking(false);
//        SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT);
//        ByteBuffer buffer = ByteBuffer.allocate(256);
//        channel.configureBlocking(false);

//        SelectionKey key1 = channel.register(selector, SelectionKey.OP_READ);


//        while(true) {
//            int readyChannels = selector.selectNow();
//
//            if(readyChannels == 0) System.out.println("zero");;


//            Set<SelectionKey> selectedKeys = selector.selectedKeys();

//            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

//            while(keyIterator.hasNext()) {

//                SelectionKey key = keyIterator.next();
//
//                if(key.isAcceptable()) {
//                    // a connection was accepted by a ServerSocketChannel.
//                    System.out.println("acceptable");
//                    key.attach(null);
//                } else if (key.isConnectable()) {
//                    // a connection was established with a remote server.
//                    System.out.println("connection");
//                } else if (key.isReadable()) {
//                    // a channel is ready for reading
//                    System.out.println("reading");
//                } else if (key.isWritable()) {
//                    // a channel is ready for writing
//                    System.out.println("writing");
//                }

//                keyIterator.remove();
//            }
//        }
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
    Function f;
    PriorityQueue p;
    Deque dq;
}

class A {
    private  int a = 1;
    private String ss = new B().s;
     class B {
        private int d = a;
        private String s = "2";

         @Override
         public String toString() {
             return "B{" +
                     "d=" + d +
                     ", s='" + s + '\'' +
                     '}';
         }
     }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", ss='" + ss + '\'' +
                '}';
    }

    public static void main(String[] args) {
         A a = new A();
        System.out.println(a);
        B b = a.new B();
        System.out.println(b);
    }
}
