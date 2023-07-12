
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Scratch {
    ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);
    ConcurrentMap<ConcurrentMap<Long, Long>, Long> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        scratch.test();
        Thread thread = new Thread(new MyThread());
        thread.start();
    }

    public void test(){
        ConcurrentMap<Map.Entry<ConcurrentMap<Long, Long>, Long>, Long> m = new ConcurrentHashMap<>();
        ThreadLocal<Long> t = new ThreadLocal<>();
        ThreadLocal<Long> t2 = new ThreadLocal<>();
        Random r = new Random(47);
        t.set((long)r.nextInt(9999));
        t2.set((long)r.nextInt(9999));
        ConcurrentMap<Long, Long> innerMap = new ConcurrentHashMap<>();
        for(int i = 0; i < 1; i++) {
            // threadLocal.set((long) atomicInteger.addAndGet(1));
            threadLocal.set((long) atomicInteger.get());
            //System.out.println(threadLocal.get());
            long driverId = t.get();
            long orgId = t2.get();
            innerMap = new ConcurrentHashMap<>();
            innerMap.put(driverId, orgId);
            map.merge(innerMap, 0L, (val, val1) -> val + 1);
        }
        System.out.println(map);
        System.out.println(map.get(innerMap));
        if(map.get(innerMap) > 0) {
            System.out.println("random");
        } else System.out.println("0000");
        // System.out.println(map);

    }
}

class MyThread implements Runnable {
    ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);
    ConcurrentMap<ConcurrentMap<Long, Long>, Long> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            //threadLocal.set((long) atomicInteger.addAndGet(1));
            threadLocal.set((long) atomicInteger.get());
            long driverId = ThreadLocalRandom.current().nextLong(9999);
            long orgId = ThreadLocalRandom.current().nextLong(9999);
            ConcurrentMap<Long, Long> innerMap = new ConcurrentHashMap<>();
            innerMap.put(driverId, orgId);
            map.put(innerMap, threadLocal.get());
//            if(map.containsKey(innerMap)) {
//                threadLocal.set((long) atomicInteger.addAndGet(1));
//            }
        }
        System.out.println(map);
    }
}