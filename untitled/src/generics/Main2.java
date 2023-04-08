package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

    }

    private static <T extends Cloass1 > List<T> getViolationListByRuleSet() {
        List<T> violationList = new ArrayList<>();
        StringBuilder s;
        List<Cloass2> list2 = new ArrayList<>();
        List<Cloass3> list3 = new ArrayList<>();
        List<Cloass1> list1 = new ArrayList<>();

        violationList.addAll((List<T>) list2);
        violationList.addAll((List<T>) list3);
        violationList.addAll((List<T>) list1);
        return violationList;
    }
    class Cloass0 {
    }

    class Cloass1 extends Cloass0 {
    }

    class Cloass2 extends Cloass1 {
    }

    class Cloass3 extends Cloass2 {
    }
}
