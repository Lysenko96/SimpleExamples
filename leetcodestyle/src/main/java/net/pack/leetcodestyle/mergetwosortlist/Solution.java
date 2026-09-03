package net.pack.leetcodestyle.mergetwosortlist;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode l1 = new ListNode(3, new ListNode(2));
        solution.mergeTwoLists(l, l1);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if (list1 != null) {
            addToList(list, list1);
        }
        if (list2 != null) {
            addToList(list, list2);
        }
        list.sort(Integer::compareTo);
        ListNode listNode = new ListNode(list.get(0), new ListNode(list.get(1), new ListNode()));
        ListNode ll = new ListNode();
        addToNode(ll, list);
        return listNode;
    }

    private void addToNode(ListNode listNode, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            ListNode next = new ListNode();
            if (i != list.size()-1) {
                listNode.val = list.get(i);
                listNode.next = next;
                listNode = next;
            } else {
                listNode.val = list.get(i);
                listNode.next = null;
            }
        }
    }

    private void addToList(List<Integer> list, ListNode list1) {
        while (list1.next != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        list.add(list1.val);
    }
}

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