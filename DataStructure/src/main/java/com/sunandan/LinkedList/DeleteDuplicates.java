package com.sunandan.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicates {

    public Node deleteDuplicates(Node head) {
        Node node = head;
        while (node != null) {
            Node nextNode = node.next;
            while (nextNode != null && nextNode.data == node.data) {
                nextNode = nextNode.next;
            }
            node.next = nextNode;
            node = node.next;
        }
        return head;
    }

    public List<Integer> getList(Node head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.data);
            head = head.next;
        }
        return result;
    }

}
