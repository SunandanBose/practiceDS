package com.sunandan.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public RandomLinkedListNode copyRandomList(RandomLinkedListNode head) {
        Map<RandomLinkedListNode, RandomLinkedListNode> cache = new LinkedHashMap<>();
        RandomLinkedListNode node = head;
        while (node != null) {
            cache.put(node, new RandomLinkedListNode(node.data));
            node = node.next;
        }

        node = head;
        while (node != null) {
            cache.get(node).next = cache.get(node.next);
            cache.get(node).random = cache.get(node.random);
            node = node.next;
        }
        return cache.get(head);
    }

}
