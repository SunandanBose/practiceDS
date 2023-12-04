package com.sunandan.leetcode;


import java.util.List;

public class LinkedNode {
    int val;
    LinkedNode next;

    LinkedNode() {
    }

    LinkedNode(int val) {
        this.val = val;
    }

    LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    public static LinkedNode insert(List<Integer> list) {
        if (list.size() == 0) return null;
        LinkedNode head = new LinkedNode(list.get(0));
        LinkedNode temp = head;
        for (int i = 1; i < list.size(); i++) {
            LinkedNode node = new LinkedNode(list.get(i));
            node.next = null;
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static String getLinkedListAsString(LinkedNode head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(String.valueOf(head.val));
            head = head.next;
        }
        return result.toString();
    }
}
