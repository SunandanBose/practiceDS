

import java.util.*;
class LList{
		static int findLastKthElement(Node head,Node iterator, Node result, int index_of_element_to_find){
			if(iterator.next == null)
				return result.data;
			if(index_of_element_to_find==0)
				result = head.next;
			return findLastKthElement(head,iterator.next,result.next,--index_of_element_to_find);
		}

			
		private static void print(Node temp){
	        while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
	    }

	    static boolean palindromeCheck(Node node){
	    	Node reversedLinkedList = reverseLinkedList(node);
	    	return isReverseAndOriginalEqual(node,reversedLinkedList);
	    }

	    static Node reverseLinkedList(Node node){
	    	Node head = null;
	    	while(node!=null){
	    		Node newNode = new Node(node.data);
	    		newNode.next = head;
	    		head = newNode;
	    		node=node.next;
	    	}
	    	return head;
	    }

	    static boolean isReverseAndOriginalEqual(Node originalLikedList, Node reverseLinkedList){
	    	while(originalLikedList!=null || reverseLinkedList != null){
	    		if(originalLikedList.data != reverseLinkedList.data)
	    			return false;
	    		originalLikedList=originalLikedList.next;
	    		reverseLinkedList=reverseLinkedList.next;
	    	}
	    	return true;
	    }
		
	    static Node insert(){
	    	List<Integer> list = Arrays.asList(2,3,4,3,2,1);
	    	Node head = new Node(1);
			Node temp = head;
			for (int i = 0;i < 6 ;i+=1) {
			    Node node =  new Node(list.get(i));
			    node.next = null;
			    temp.next = node;
			    temp = node;
			}
			return head;
	    }

		public static void main(String[] args) {
		Node head =  insert();
		print(head);
		System.out.println();
		//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
		System.out.println("Answer: "+findLastKthElement(head,head ,head, 3));

		//write a function to check if a linkedList is Palindrome or not
		System.out.println("Palindrome linkedList: "+palindromeCheck(head));
				

    }




}


class Node{
	int data;
	Node next;

	Node(int data){
		this.data=data;	
	}
}