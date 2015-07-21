package edu.sjtu.holmes.medium;

/**
 * Created by holmes on 7/20/15.
 */

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNums {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int sum = 0;
        int delta = 0;
        while (c1!=null || c2!=null){
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            sum += delta;
            delta = sum/10;
            head.next = new ListNode(sum%10);
            head = head.next;
        }
        if(delta != 0){
            head.next = new ListNode(delta);
        }
        return pre.next;
    }

}
