package com.florebencia.filsaime;

import com.florebencia.filsaime.implement.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    private final AddTwoNumbers addTwoNumbers =  new AddTwoNumbers();

    @Test
    public void getLinkedListValueTest() {
        ListNode tail = new ListNode(4);
        ListNode element2 = new ListNode(3, tail);
        ListNode head = new ListNode(2, element2);

        long answer = addTwoNumbers.getLinkedListValue(head);
        Assertions.assertEquals(432L, answer);
    }

    @Test
    public void getLinkedListSingleValueTest() {
        ListNode head = new ListNode(9);

        long answer = addTwoNumbers.getLinkedListValue(head);
        Assertions.assertEquals(9, answer);
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode tail = new ListNode(3);
        ListNode element2 = new ListNode(4, tail);
        ListNode head = new ListNode(2, element2);

        ListNode tail2 = new ListNode(4);
        ListNode element3 = new ListNode(6, tail2);
        ListNode head2 = new ListNode(5, element3);

        ListNode answer = addTwoNumbers.addTwoNumbers(head, head2);
        Assertions.assertEquals(7, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(8, answer.val);
    }

    @Test
    public void addTwoNumbersTest2() {
        ListNode head = new ListNode(9, null);

        ListNode tail8 = new ListNode(9);
        ListNode tail7 = new ListNode(9, tail8);
        ListNode tail6 = new ListNode(9, tail7);
        ListNode tail5 = new ListNode(9, tail6);
        ListNode tail4 = new ListNode(9, tail5);
        ListNode tail2 = new ListNode(9, tail4);
        ListNode tail3 = new ListNode(9, tail2);
        ListNode tail = new ListNode(9, tail3);
        ListNode element3 = new ListNode(9, tail);
        ListNode head2 = new ListNode(1, element3);

        ListNode answer = addTwoNumbers.addTwoNumbers(head, head2);
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(0, answer.val);

        answer = answer.next;
        Assertions.assertEquals(1, answer.val);
    }
}
