package com.sunandan.LinkedList;
class Node{
	public int data;
	public Node next;
	Node(int data){
	    this.data = data;
	}
	
	//public Node previous;
}

public class Linked_List{
	public static void main(String[] args) {
		Node head = new Node(1);
		Node temp = head;
		for (int i = 0;i < 5 ;i+=1) {
		    Node node =  new Node((int)(Math.random() * 100));
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
    private static void print(Node temp){
        while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
    }
    
    private static Node reverseLinkedList(Node node){
        if(node == null) return null;
        if(node.next == null) return node;
        Node SecondElem = node.next;
        node.next = null;
        Node reverse = reverseLinkedList(SecondElem);
        SecondElem.next = node;
        return reverse;
    }
}
