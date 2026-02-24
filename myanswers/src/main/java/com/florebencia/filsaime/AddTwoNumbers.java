package com.florebencia.filsaime;

import com.florebencia.filsaime.implement.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//leet code problem: https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add the numbers as you go and have a carry to keep track
        //doing the first value
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10, null);
        int carry = sum / 10;
        ListNode pointer = head;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(sum % 10, null);
            pointer.next = newNode;
            pointer = pointer.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        // just in case the left list is greater than the right
        // and make sure to use the carry
        while(l1 != null){
            sum = carry + l1.val;
            ListNode newNode = new ListNode(sum % 10, null);
            pointer.next = newNode;
            pointer = pointer.next;
            carry = sum / 10;
            l1 = l1.next;
        }

        // just in case the right list is bigger than the left
        // and make sure to use the carry
        while(l2 != null){
            sum = carry + l2.val;
            ListNode newNode = new ListNode(sum % 10, null);
            pointer.next = newNode;
            pointer = pointer.next;
            carry = sum / 10;
            l2 = l2.next;
        }

        // don't forget about the carry
        if (carry == 1) {
            ListNode newNode = new ListNode(1, null);
            pointer.next = newNode;
        }

        return head;
    }
}
