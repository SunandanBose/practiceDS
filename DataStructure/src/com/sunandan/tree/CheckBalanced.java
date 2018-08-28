package com.sunandan.tree;

public class CheckBalanced{

	//static Node root;
	private Node createBinaryTreeWithSortedArray(int[] arr,int first_pos,int last_pos){
		   if(first_pos>last_pos)
		   		return null;
		   int mid = (first_pos + last_pos)/2;
		   Node node = new Node(arr[mid]);
		   node.left = createBinaryTreeWithSortedArray(arr, first_pos, mid-1);
		   node.right = createBinaryTreeWithSortedArray(arr, mid+1, last_pos);
		   return node;
	}
	private boolean isBalanced(Node node) 
    {
        int lh;
        int rh; 
        if (node == null) return true;
        lh = height(node.left);
        rh = height(node.right);
  
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) 
            return true;
        return false;
    }
    private int height(Node node) 
    {
        if (node == null)
            return 0;
        int a = 1 + Math.max(height(node.left), height(node.right));
        System.out.println(node.data + " "+a);
        return a;
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
	public static void main(String args[]){
		CheckBalanced b=new CheckBalanced();
		Node root = null;
		/*int[] a={4,2,1,5,6,3};
    	int i=0;
    	while(6>i){
    		root=insert(root,a[i]);
    		i++;
    	}*/
		int[] arr = {1,2,3,4,5,6,7};
		root  = b.createBinaryTreeWithSortedArray(arr, 0, arr.length-1);
		System.out.println(b.isBalanced(root));
	}




}
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data =  data;
		this.left=null;
		this.right=null;
	}
}