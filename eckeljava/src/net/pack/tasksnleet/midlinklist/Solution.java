package net.pack.tasksnleet.midlinklist;

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
       // System.out.println(new Solution().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6,null))))))));
        System.out.println(new Solution().middleNode(new ListNode(1, null)));
    }

    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode node = head;
        ListNode myNode = null;
        // System.out.println(node);
        while (node.next != null) {
            //  System.out.println(node);
            node = getNext(node);
            count++;
        }
        if (count == 2 || count == 1) {
            return head;
        } else if (count % 2 != 0) {
            count = (count / 2) + 1 ;
        } else {
            count = count / 2 + 1;
        }
       // System.out.println(count);
        int countZ = 2;
        while (true) {
            if (countZ < count) {
                myNode = getNext(head);
                head = myNode;
                countZ++;
            }
            if (countZ == count) {
                myNode = new ListNode(head.val, head.next);
                break;
            }
        }
        return myNode;
    }

    private ListNode getNext(ListNode head) {
        head.val = head.next.val;
        head.next = head.next.next;
        return new ListNode(head.val, head.next);
    }
}
