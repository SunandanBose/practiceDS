package com.sunandan.tree;

public class AVLTreeBalancing {

	private Node creteBinaryTreeFromArray(int[] array,int first,int last){
		if(first > last)
			return null;
		int mid = (first + last)/ 2;
		Node node = new Node(array[mid]);
		node.left = creteBinaryTreeFromArray(array, first, mid-1);
		node.right = creteBinaryTreeFromArray(array, mid +1 ,last);
		return node;
	}


	private boolean isBalanced(Node root) {
		if(root == null) return true;
		int lhs = height(root.left);
		int rhs = height(root.right);

		if(Math.abs(lhs-rhs)<=1)
			balanceNode(root);

		if(Math.abs(lhs-rhs)<=1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
	}

	private Node balanceNode(Node root){

		int balance = height(root.left) - height(root.right);
		if(balance > 1){
			if( height(root.left.left) > height(root.left.right)){
				return rightRotate(root.left);
			}
			if( height(root.left.left) < height(root.left.right)){
				return rightRotate(leftRotate(root.left));
			}
		}
		if(balance < -1){
			if( height(root.left.left) < height(root.left.right)){
				return leftRotate(root.left);
			}
			if( height(root.left.left) > height(root.left.right)){
				return leftRotate(rightRotate(root.left));
			}
		}
		return root;
	}

	/*
	 * Main Logic
	 *
          y
        /   \
       x     z
      / \   / \
     T1 T2 T3 T4
     if the tree is not balanced from node y if
     *	height of x > z and height of T1 > T2 right rotate around x
     		here after right rotation x will be the root y will be the right child of x and T2 will be the left child of y
     *	height of x > z and height of T2 > T1 left rotate will be performed around x followed by right rotate around y
     		left rotate:
     			T2 will be the root x will be the left child of T2 and the left child of T2 will be the right child of x
     		right rotate:
     		 	T2 will be the root y will be the right child of T2 and the right child of T2 will be the left child of y
     *	height of x < z and height of T3 < T4 left rotate around z
     		here after left rotation z will be the root y will be the left child of z and T3 will be the right child of y
     *	height of x < z and height of T3 > T4 right rotate will be performed around z followed by left rotate around y
     		right rotate:
     			T3 will be the root z will be the right child of T3 and the right child of T3 will be the left child of z
     		left rotate:
     		 	T3 will be the root y will be the left child of T3 and the left child of T3 will be the right child of y
	 */
	private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;

        return y;
    }

	private int height(Node node) {
		if(node == null) return 0;
		return 1+ Math.max(height(node.left) , height(node.right));
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
	public static void main(String[] args) {
		AVLTreeBalancing createTree = new AVLTreeBalancing();
		int[] array = {1,2,3,4,5,6,7};
		Node root = createTree.creteBinaryTreeFromArray(array, 0, array.length-1);
		if(createTree.isBalanced(root)){
			System.out.println("It is balanced");
		}
		else{
			System.out.println("It is not balanced");
		}
		insert(root , 10);
		insert(root , 13);
		if(createTree.isBalanced(root)){
			System.out.println("It is balanced");
		}
		else{
			System.out.println("It is not balanced");
		}


	}


}

/*class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data =  data;
		this.left=null;
		this.right=null;
	}
}*/
