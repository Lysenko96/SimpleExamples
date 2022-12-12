package info.lysenko.anton.patterns.command.adapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        List<Integer> list = new ArrayList<>();
        list.add(2);
        EnumerationIterator<String> enumerationIterator = new EnumerationIterator<>(stack.elements());
        //enumerationIterator.remove();
        System.out.println(enumerationIterator.hasNext());
        System.out.println(enumerationIterator.next());
        System.out.println(enumerationIterator.hasNext());
        IteratorEnumeration<Integer> iteratorEnumeration = new IteratorEnumeration<>(list.iterator());
        System.out.println(iteratorEnumeration.hasMoreElements());
        System.out.println(iteratorEnumeration.nextElement());
        System.out.println(iteratorEnumeration.hasMoreElements());
    }
}
