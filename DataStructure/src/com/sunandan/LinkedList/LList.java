

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
		
	    static Node insert(List<Integer> list){
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

	    private static Node removeDuplicateElements(Node node){
	    	Node tempNode=node,previousNode=null;
	    	Set<Integer> tempSetToCheckDuplicates = new HashSet<Integer>();
	    	while(tempNode!=null){
	    		if(tempSetToCheckDuplicates.contains(tempNode.data)){
	    			tempNode = deleteNodeFromLinkedList(previousNode,tempNode);
	    		}
	    		else{
	    			tempSetToCheckDuplicates.add(tempNode.data);
	    		}
	    		previousNode=tempNode;
	    		tempNode=tempNode.next;
	    	}
	    	return node;
	    }

	    private static Node deleteNodeFromLinkedList(Node previousNode, Node nodeToRemove){
	    	previousNode.next= nodeToRemove.next;
	    	return previousNode;

	    }

	    private static Node removeDuplicateElementsWithoutBuffer(Node head){
	    	Node tempNode=head,previousNode = null,tempNode1=head;
	    	while(tempNode!=null){
	    		tempNode1=tempNode.next;
	    		previousNode = tempNode;
	    		while(tempNode1!=null){
	    			if(tempNode1.data == tempNode.data)
	    				deleteNodeFromLinkedList(previousNode,tempNode1);
	    			previousNode=tempNode1;
	    			tempNode1=tempNode1.next;
	    		}
	    		tempNode=tempNode.next;
	    	}
	    	return head;
	    }

		public static void main(String[] args) {
		Node head =  insert(Arrays.asList(2,3,4,3,2,1));
		print(head);
		System.out.println();
		//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
		System.out.println("Answer: "+findLastKthElement(head,head ,head, 3));

		//write a function to check if a linkedList is Palindrome or not
		System.out.println("Palindrome linkedList: "+palindromeCheck(head));

		//remove duplicate elements in a linkedlist
		System.out.println("remove duplicate elements in a linkedlist");
		Node startNodeOfDistinctList = removeDuplicateElements(head);
		print(startNodeOfDistinctList);

		//remove duplicate elements in a linkedlist without buffer
		head= insert(Arrays.asList(2,3,4,3,2,5));
		System.out.println();
		System.out.println("remove duplicate elements in a linkedlist without buffer");
		startNodeOfDistinctList = removeDuplicateElementsWithoutBuffer(head);
		print(startNodeOfDistinctList);
    }

}


class Node{
	int data;
	Node next;

	Node(int data){
		this.data=data;	
	}
}