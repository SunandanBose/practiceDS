package com.sunandan.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class topView {
	static List<Node> lateralOrderList = new ArrayList<Node>();
    public static void main(String[] args) {
    	int n=6;
    	int[] a={4,2,1,5,6,3};
    	Node root = null;
    	int i=0;
    	while(n>i){
    		root=insert(root,a[i]);
    		i++;
    	}
    	Queue<Node> queueList = new LinkedList<Node>();
    	queueList.add(root);
    	lateralOrderTraversal(root, queueList);
    	System.out.print("Lateral Order Traversal is : ");
    	lateralOrderList.forEach(l -> System.out.print(l.data + " "));
    	System.out.println();
    	TreeMap<Integer,ArrayList<Integer>> verticalOrderList = new TreeMap<>();
    	verticalOrderTraversal(root, 0, verticalOrderList);
    	topview(verticalOrderList);
    }

	private static void topview(TreeMap<Integer, ArrayList<Integer>> verticalOrderList) {
		System.out.print("Top View of the List  : ");
		Set<Integer> keys = verticalOrderList.keySet();
		for(Integer i : keys){
			System.out.print(verticalOrderList.get(i).get(0) + " ");
		}
		
		System.out.println();
		
	}

	private static void verticalOrderTraversal(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> verticalOrderList) {
		if(root == null) return;
		if(verticalOrderList.get(hd) != null){
			verticalOrderList.get(hd).add(root.data);
		}
		if(verticalOrderList.get(hd) == null){
			ArrayList<Integer> orderList = new ArrayList<>();
			orderList.add(root.data);
			verticalOrderList.put(hd, orderList);
		}
		verticalOrderTraversal(root.left, hd - 1, verticalOrderList);
		verticalOrderTraversal(root.right, hd + 1, verticalOrderList);
		
	}

	private static void lateralOrderTraversal(Node root, Queue<Node> queueList) {
		if(queueList.isEmpty()) return;
		if(queueList.peek().left != null)
			queueList.add(queueList.peek().left);
		if(queueList.peek().right != null)
			queueList.add(queueList.peek().right);
		lateralOrderList.add(queueList.remove());
		lateralOrderTraversal(queueList.peek(),queueList);
	}

	private static Node insert(Node root, int data) {
		if(root ==  null){
			return new Node(data);
		}
		if(root.data<data){
			root.right = insert(root.right,data);
		}
		if(root.data>data){
			root.left = insert(root.left,data);
		}
		return root;
			
	}
    
	
}