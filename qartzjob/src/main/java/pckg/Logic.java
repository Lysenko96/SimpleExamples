package pckg;

import pckg.scheduler.SchedulerWorker;

public class Logic {

    public static void main(String[] args) {
        try {//abm offline key -> map get operation on check
            SchedulerWorker worker = new SchedulerWorker("consumer",
                    (x) -> System.out.println("Hello World"),"job", "group",
                    "trigger", "group", "*/5 * * * * ?");
            SchedulerWorker worker1 = new SchedulerWorker("consumer",
                    (x) -> System.out.println("Bye World"),"job1", "group1",
                    "trigger1", "group1", "*/5 * * * * ?");
            worker.start();
            worker1.start();
//            worker.shutdownAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
