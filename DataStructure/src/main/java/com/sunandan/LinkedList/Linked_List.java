package com.sunandan.LinkedList;


public class Linked_List {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 0; i < 5; i += 1) {
            Node node = new Node((int) (Math.random() * 100));
            node.next = null;
            temp.next = node;
            temp = node;
        }
        print(head);

        Node temp1 = reverseLinkedList(head);
        System.out.println();
        System.out.println("Reverse Linked List");
        print(temp1);


    }

    private static void print(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node reverseLinkedList(Node node) {
        if (node == null) return null;
        if (node.next == null) return node;
        Node SecondElem = node.next;
        node.next = null;
        Node reverse = reverseLinkedList(SecondElem);
        SecondElem.next = node;
        return reverse;
    }

    public Node rotateRight(Node head, int n) {
        if (head == null || head.next == null) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;

        int length;
        for (length = 0; fast.next != null; length++)//Get the total length
            fast = fast.next;

        int rotate = n % length;
        for (int j = length - rotate; j > 0; j--) //Get the length-n%length th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
