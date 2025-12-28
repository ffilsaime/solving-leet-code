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
        // todo change all ints into a long
        int l1Value = getLinkedListValue(l1);
        int l2Value = getLinkedListValue(l2);
        int solution = l1Value + l2Value;

        //need to figure out a better way of getting each digit
        int divisor = 10;
        int prevDivisor = 1;
        int quotient = 0;

        quotient = (solution % divisor);
        ListNode head = new ListNode(quotient);
        ListNode tail = head;

        prevDivisor *= 10;
        divisor *= 10;

        while ((solution / prevDivisor) != 0){
            quotient = (solution % divisor) / prevDivisor;
            ListNode temp = new ListNode(quotient);
            tail.next = temp;
            tail = temp;
            prevDivisor *= 10;
            divisor *= 10;
        }

        return head;
    }

    public int getLinkedListValue (ListNode test){
        int solution = 0;
        int multiplier = 1;
        ListNode nextNode = test;
        while (nextNode != null){
            solution = solution + (nextNode.val * multiplier);
            nextNode = nextNode.next;
            multiplier *= 10;
        }

        return solution;
    }
}
