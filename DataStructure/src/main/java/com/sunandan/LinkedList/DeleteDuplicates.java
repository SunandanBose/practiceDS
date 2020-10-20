package com.sunandan.LinkedList;


//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class DeleteDuplicates {

    public Node deleteDuplicates(Node head) {
        Node node = head;
        while(node != null){
            Node nextNode = node.next;
            while(nextNode != null && nextNode.data==node.data){
                nextNode = nextNode.next;
            }
            node.next = nextNode;
            node = node.next;
        }
        return head;
    }
    
}
