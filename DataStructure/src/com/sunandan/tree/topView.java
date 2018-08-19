package com.sunandan.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class topView {

	public static List<Node> queueOfElements = new ArrayList<>();
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
    	int[] a= {2,1,5,3,6,4};
        int n = 6;
        int i=0;
        Node root = null;
        while(i < n) {
            int data = a[i++];
            root = insert(root, data);
        }
        //printtopView(root);
        Queue<Node> list = new LinkedList<Node>();
        list.add(root);
        levelOrderTraversal(root, list);
        TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,m);
        for (Entry<Integer, ArrayList<Integer>> entry : m.entrySet())
        {
            System.out.println(entry.getValue());
        }
        gettopview(m,queueOfElements);
        /*Map<Node,Integer> horizontalDistance = new TreeMap<>();
        horizontalDistance.put(root, 0);
        verticalOrderTraversal(root,horizontalDistance, new Hashtable<Integer,ArrayList<Integer>>(),list);*/
    }
    
	private static void gettopview(TreeMap<Integer, ArrayList<Integer>> m, List<Node> queueOfElements) {
		Set<Integer> keysets = m.keySet();
		for(Integer i : keysets) {
			if(m.get(i).size()==1) {
				System.out.print(+m.get(i).get(0)+ " ");
			}
			else {
				for(Node n : queueOfElements) {
					if(m.get(i).contains(n.data)) {
						System.out.print(n.data+ " ");
						break;
					}
				}
			}
		}
	}

	static void getVerticalOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
		if (root == null)
			return;
		ArrayList<Integer> get = m.get(hd);
		if (get == null) {
			get = new ArrayList<>();
			get.add(root.data);
		}
		else
			get.add(root.data);
		m.put(hd, get);
		getVerticalOrder(root.left, hd - 1, m);
		getVerticalOrder(root.right, hd + 1, m);
	}
	/*private static void verticalOrderTraversal(Node root, Map<Node, Integer> horizontalDistance,
			Hashtable<Integer, ArrayList<Integer>> hashtable,Queue<Node> queue) {
		if(queue.isEmpty()) {
			hashtable.keySet().stream().forEach(i -> System.out.println(i +"   "+hashtable.get(i)));
			return;
		}
		if(root.left != null) {
			queue.add(root.left);
			horizontalDistance.put(root.left, horizontalDistance.get(root)-1);
			if(hashtable.get(horizontalDistance.get(root)-1) == null)
				hashtable.put(horizontalDistance.get(root)-1, root.left.data);
			else {
				boolean add = hashtable.get(horizontalDistance.get(root)-1).add(root.left.data);
				hashtable.put(horizontalDistance.get(root)-1, 
					add);
			}
		}
		if(root.right!=null) {
			queue.add(root.right);
			horizontalDistance.put(root.right, horizontalDistance.get(root)+1);
			hashtable.put(horizontalDistance.get(root)+1, root.right.data);
		}
		//System.out.print(queue.peek().data + " ");
		queue.remove();
		verticalOrderTraversal(queue.peek(),horizontalDistance, hashtable, queue);
		
	}*/

	private static void levelOrderTraversal(Node root, Queue<Node> queue) {
		if(queue.isEmpty()) return;
		if(root.left != null)
			queue.add(root.left);
		if(root.right!=null)
			queue.add(root.right);
		System.out.print(queue.peek().data + " ");
		queueOfElements.add(queue.remove());
		levelOrderTraversal(queue.peek(), queue);
		
	}	
}
