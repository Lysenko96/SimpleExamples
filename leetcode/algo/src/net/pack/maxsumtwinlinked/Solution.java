package net.pack.maxsumtwinlinked;

import java.util.ArrayList;
import java.util.Collections;
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
}

public class Solution {

    public static void main(String[] args) {
        ListNode nodeLast5 = new ListNode(33);
        ListNode nodeLast4 = new ListNode(2, nodeLast5);
        ListNode nodeLast3 = new ListNode(5, nodeLast4);
        ListNode nodeLast2 = new ListNode(4, nodeLast3);
        ListNode nodeLast = new ListNode(0, nodeLast2);
        ListNode node = new ListNode(1, nodeLast);
        ListNode head = new ListNode(3, node);
        ListNode prevHead = new ListNode(1, head);
        System.out.println(new Solution().pairSum(prevHead));
    }

    public int pairSum(ListNode head) {
        int sum = 0;
        sum += head.val;
        int count = 1;
        List<Integer> vals = new ArrayList<>();
        vals.add(head.val);
        do {
            //System.out.println(head);

            head = getNext(head);
            vals.add(head.val);
            count++;
            if(head.next == null){
                sum += head.val;
            }
        } while (head.next != null);
       // System.out.println(vals);
        int fIndex = 0;
        int lIndex = vals.size()-1;
        List<Integer> sums = new ArrayList<>();
        while (fIndex < lIndex){
            sums.add(vals.get(fIndex) + vals.get(lIndex));
            fIndex++;
            lIndex--;
        }
        //System.out.println(sums);
        return Collections.max(sums);
    }

    private ListNode getNext(ListNode node) {
        return new ListNode(node.next.val, node.next.next);
    }
}
