package org.example.projectoop.collection;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionUtil {

    // Collection
    // access by index, ordered
    Object obj = new Object();
    Object obj2 = new Object();
    List<Object> arrayList = new ArrayList<>();
    // (fast insert, delete) ?
    List<Object> linkedList = new LinkedList<>();
    // synchronized arraylist, thread-safe
    List<Object> vector = new Vector<>();
    // LIFO
    Stack<Object> stack = new Stack<>();
    // not ordered, not sorted, all sets - unique objects
    Set<Object> set = new HashSet<>();
    // ordered, not sorted
    Set<Object> linkedHashSet = new LinkedHashSet<>();
    // sorted, not ordered, need Comparator
    TreeSet<Object> treeSet = new TreeSet<>();
    SortedSet<Object> sortedSet = new TreeSet<>();
    // FIFO
    Queue<Long> priorityQueue = new PriorityQueue<>(1);
    // FIFO synchronized based on arraylist
    BlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    // FIFO synchronized based on linkedlist
    BlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    // if you need pair
    // not ordered, not sorted, map - unique keys
    Map<String, Object> map = new HashMap<>();
    // ordered, not sorted
    Map<String, Object> linkedHashMap = new LinkedHashMap<>();
    // not ordered, sorted
    Map<String, Object> treeMap = new TreeMap<>();


    public void test() {
        arrayList.add(obj);
        arrayList.get(0);
        arrayList.add(0, obj2); // add to index
        arrayList.remove(obj);
        arrayList.set(0, obj); // set to index
        arrayList.size();
        arrayList.indexOf(obj); // get index of obj
        //------------------------
        linkedList.add(obj);
        linkedList.get(0);
        linkedList.add(0, obj2); // add to index
        linkedList.remove(obj);
        linkedList.set(0, obj); // set to index
        linkedList.size();
        linkedList.indexOf(obj); // get index of obj
        //-------------------------
        vector.add(obj);
        vector.get(0);
        vector.add(0, obj2); // add to index
        vector.remove(obj);
        vector.set(0, obj); // set to index
        vector.size();
        vector.indexOf(obj); // get index of obj
        //-------------------------
        stack.push(1L); // add
        stack.push(2L);
        stack.peek(); // get last add Object
        stack.pop(); // get and delete last add Object
        stack.empty(); // is empty
        stack.search(1L); // position object in stack
        stack.indexOf(1L); // get index of obj
        //-------------------------
        set.add(1L);
        set.remove(1L);
        set.size();
        //-------------------------
        linkedHashSet.add(1L);
        linkedHashSet.remove(1L);
        linkedHashSet.size();
        //-------------------------
        treeSet.add(-1L);
        treeSet.add(2L);
        treeSet.add(3L);
        treeSet.remove(2L);
        treeSet.size();
        treeSet.first(); // get first add object
        treeSet.ceiling(2L); // find near more object else null
        treeSet.floor(2L); // find near less object else null
        //-------------------------
        sortedSet.add(1L);
        sortedSet.add(2L);
        sortedSet.add(3L);
        sortedSet.headSet(2L); // get set objects less than set
        sortedSet.subSet(1L, 3L); // get set objects from to (not include last object)
        sortedSet.tailSet(2L); // get set objects more than set
        sortedSet.first();
        sortedSet.last();
        //-------------------------
        // Queue no exception when add or offer if set capacity
        priorityQueue.add(3L);
        priorityQueue.add(31L);
        priorityQueue.add(32L);
        priorityQueue.element(); // get first add object if empty - exception
        priorityQueue.peek(); // get first add object if empty - null
        priorityQueue.poll(); // return and remove first add object if empty - null
        priorityQueue.remove(); // return and remove first add object if empty - exception
        //-------------------------
        // LinkedBlockingQueue, ArrayBlockingQueue yes exception when add or offer if set capacity
        arrayBlockingQueue.add(1L); // if more than capacity - exception
        arrayBlockingQueue.offer(2L); // if more than capacity - no add object
        try {
            arrayBlockingQueue.put(3L);// if capacity less than when put - wait
            arrayBlockingQueue.take(); // if capacity empty - wait
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        arrayBlockingQueue.remainingCapacity(); // remained capacity
        //-------------------------
        map.put("1", 1L);
        map.put("2", 2L);
        map.get("1");
        map.remove("1");
        map.getOrDefault("1", 3L); // if contains return value else default value
        map.replace("2", 5); // if contains replace else null
        map.keySet();
        map.entrySet();
        map.values();
        map.put("3", null);
        map.compute("3", (x,y) -> Long.parseLong(x) + 5); // if value not null value replace map entry, else not add
        map.computeIfAbsent("3", Long::parseLong); // don't rewrite value if exist key in map else if key null add entry
        map.computeIfPresent("3", (x,y) -> Long.parseLong(x) + 22); // if exist key in map than rewrite else not add
        System.out.println(map);
        map.put("4", 2L);
        map.merge("4", 3L, (x, y) -> (long) x * (long) y); // if key exist merge value with BiFunction else if not exist set value
        //-------------------------
    }

    public static void main(String[] args) {
        new CollectionUtil().test();
    }

}
