package com.sunandan.tree;

public class BinaryTree{

	static Node root;
	private Node createBinaryTreeWithSortedArray(int[] arr,int first_pos,int last_pos){
		   if(first_pos>last_pos)
		   		return null;
		   int mid = (first_pos + last_pos)/2;
		   Node node = new Node(arr[mid]);
		   node.left = createBinaryTreeWithSortedArray(arr, first_pos, mid-1);
		   node.right = createBinaryTreeWithSortedArray(arr, mid+1, last_pos);
		   return node;
	}
	private void printPreOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public boolean isValidBST(Node root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(Node root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.data < min || root.data > max) return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}
	public static void main(String args[]){
		BinaryTree b=new BinaryTree();
		int[] arr = {1,2,3,4,5,6,7};
		root  = b.createBinaryTreeWithSortedArray(arr, 0, arr.length-1);
		b.printPreOrder(root);
		System.out.println();
	}


}
/*class Node{
	int data;
	Node left;
	Node right;

	Node(int data){
		this.data = data;
		this.right = null;
		this.left = null;
	}
}*/