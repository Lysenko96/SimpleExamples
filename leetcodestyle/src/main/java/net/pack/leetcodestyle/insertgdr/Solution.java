package net.pack.leetcodestyle.insertgdr;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
        ListNode listNode = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));
        System.out.println(new Solution().insertGreatestCommonDivisors(listNode));
    }

    public ListNode insertGreatestCommonDivisors(ListNode head){
        ListNode next = head.next;
        ListNode current = head;
        while (next != null){
            ListNode insert =  new ListNode(findGDR(current.val,next.val));
            current.next = insert;
            insert.next = next;
            current = next;
            next = next.next;
        }
        return head;
    }

    public static int findGDR(int one, int two){
        int temp = 0;
        int gdr = 0;
        while (two != 0){
            temp = two;
            two = one % two;
            one = temp;
        }
        gdr = one;
        return gdr;
    }
}
