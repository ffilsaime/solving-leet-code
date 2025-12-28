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
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long l1Value = getLinkedListValue(l1);
        long l2Value = getLinkedListValue(l2);
        long solution = l1Value + l2Value;

        //need to figure out a better way of getting each digit
        long divisor = 10;
        long prevDivisor = 1;
        long quotient = 0;

        quotient = (solution % divisor);
        ListNode head = new ListNode(Long.valueOf(quotient).intValue());
        ListNode tail = head;

        prevDivisor *= 10;
        divisor *= 10;

        while ((solution / prevDivisor) != 0){
            quotient = (solution % divisor) / prevDivisor;
            ListNode temp = new ListNode(Long.valueOf(quotient).intValue());
            tail.next = temp;
            tail = temp;
            prevDivisor *= 10;
            divisor *= 10;
        }

        return head;
    }

    public long getLinkedListValue (ListNode test){
        long solution = 0;
        long multiplier = 1;
        ListNode nextNode = test;
        while (nextNode != null){
            long value = nextNode.val;
            solution = solution + (value * multiplier);
            nextNode = nextNode.next;
            multiplier *= 10;
        }

        return solution;
    }
}
