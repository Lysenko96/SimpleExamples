package net.pack.maxsumlinkedlist;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class Solution {

    public static void main(String[] args) {
        ListNode nodeLast5 = new ListNode(0);
        ListNode nodeLast4 = new ListNode(2, nodeLast5);
        ListNode nodeLast3 = new ListNode(5, nodeLast4);
        ListNode nodeLast2 = new ListNode(4, nodeLast3);
        ListNode nodeLast = new ListNode(0, nodeLast2);
        ListNode node = new ListNode(1, nodeLast);
        ListNode head = new ListNode(3, node);
        ListNode prevHead = new ListNode(0, head);
        new Solution().mergeNodes(prevHead);
    }

    public ListNode mergeNodes(ListNode head) {
        do {
            if(head.val != 0){
                head.val += head.next.val;
                head.next = head.next.next;
                System.out.println(head);
            }
            head = getNext(head);
           if(head.next != null) {
                head.val += head.next.val;
                head.next = head.next.next;
            }
        } while (head.next != null);
        return head;
    }

//    public ListNode mergeNodes(ListNode head) {
//        List<Integer> sums = new ArrayList<>();
//        int sum = 0;
//        int index = -1;
//        int zeroCount = 0;
//        do {
//            if (head.val != 0) {
//                sum += head.val;
//                sums.add(index, sum);
//                //  System.out.println("sum: " + sum);
//            } else {
//                sum = 0;
//                //System.out.println("sum: " + sum);
//                zeroCount++;
//                index++;
//            }
//            if (head.next == null) {
//                break;
//            }
//            head = getNext(head);
//            // System.out.println(head.val);
//            // System.out.println(head.next);
//        } while (head.next != null);
//        //System.out.println(zeroCount);
//        List<Integer> lastList = sums.subList(0, zeroCount);
//        System.out.println(lastList);
//        // ListNode from List
//
////        for (int i = 0; i < lastList.size() - 1; i++) {
////            main = new ListNode(lastList.get(i), new ListNode(lastList.get(i + 1)));
////        }
//
//        return null;
//    }



    private ListNode getNext(ListNode node) {
        return new ListNode(node.next.val, node.next.next);
    }
}
