package LessonsToInterview.TestCollections;

import java.util.*;

public class MainTestCollections {
    Collection<String> collection = new ArrayList<>();
    List<String> list = new LinkedList<>();
    Map<String, Worker> map = new HashMap<>();
    Map<Integer, Integer> hashTable = new Hashtable<>();
    private MainTestCollections(){
        collection.add("123");
        collection.add("sdfa");
        collection.add("1dsd");
        collection.remove("123");
        collection.add("fghfgh");
        collection.add("xzvcxcv");
        Iterator<String> iterator = collection.iterator();
 /*       while (iterator.hasNext()){
            System.out.println(iterator.next());
           // iterator.remove();

        }*/
       // System.out.println(collection.size());
        list.add("ddd");
        list.add("bdc");
        list.add("arc");
        Iterator iterator1 = list.iterator();
        iterator1.next();
        iterator1.next();
        iterator1.remove();
        iterator1.next();
        iterator1.remove();
      /*  for (String s:list) {
            System.out.println(s);
        }
        System.out.println(list.size());*/
     /*   for (String s:collection) {
            System.out.println(s);
        }*/
     map.put("123", new Worker("Anton",500));
     map.put(null, new Worker());
     map.put(null, new Worker("Max", 3000));
       // System.out.println(map.get(null));
       // System.out.println(map.get("321"));
        //System.out.println(map.get("123").getNameWorker());
        //System.out.println(map.get("123").getSalaryWorker());
       // System.out.println(map.entrySet());
        Map<Worker,Worker> map1 = new HashMap<>();
        map1.put(null, null);
    /*    System.out.println(map1.get(null));
        System.out.println(map1.entrySet());*/
    List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < 49 ; i++) {
            listInteger.add(i);
        }
        Collections.shuffle(listInteger);
        List<Integer> choiceInteger = listInteger.subList(0,10);
        //System.out.print(choiceInteger + " ");
        //System.out.println();
        choiceInteger = listInteger.subList(0,10);
        Collections.sort(choiceInteger);
        //System.out.print(choiceInteger + " ");
        Set<Integer> set = new HashSet();
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(9);
      /*  for (int i = 0; i < 10; i++) {
            for (Integer integer : set) {
                System.out.println(integer);
            }
        }*/
        //System.out.println();
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(2);
        queue.add(1);
        queue.remove();
        Iterator<Integer> integerIterator = queue.iterator();
     /*   for (Integer i: queue) {
            System.out.println(i);
        }*/
   /*   while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
      int d = 0;
      d = queue.size();*/
        System.out.println("queue:");
        for (Integer i:queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("peek : " + queue.peek());
        System.out.println("poll : " + queue.poll());
        System.out.println(queue.element());
        System.out.println("size: " + queue.size());

    }

    public static void main(String[] args) {
        new MainTestCollections();
    }
}

class Worker{
    private String nameWorker = null;
    private int salaryWorker = 0;
    Worker(){

    }
    Worker(String name, int salary){
        this.nameWorker = name;
        this.salaryWorker = salary;
    }
    public String getNameWorker() {
        return nameWorker;
    }

    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    public int getSalaryWorker() {
        return salaryWorker;
    }

    public void setSalaryWorker(int salaryWorker) {
        this.salaryWorker = salaryWorker;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "nameWorker='" + nameWorker + '\'' +
                ", salaryWorker=" + salaryWorker +
                '}';
    }
}