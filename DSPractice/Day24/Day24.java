import java.util.*;

/**
 * Day24
 */
public class Day24 {

    public static void main(String[] args) {
        int n = 6;
        int[] a = { 4, 2, 1, 5, 6, 3 };
        Node root = null;
        int i = 0;
        while (n > i) {
            root = insert(root, a[i]);
            i++;
        }
        Day24 day24 = new Day24();
        System.out.println(day24.lateralOrderTraversal(root));
    }

    private LinkedList<Integer> lateralOrderTraversal(Node root) {
        LinkedList<Integer> lateralOrderList = new LinkedList<>();
        if (root == null)
            return lateralOrderList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        return lateralOrderTraversal(root, lateralOrderList, queue);
    }

    private LinkedList<Integer> lateralOrderTraversal(Node root, LinkedList<Integer> lateralOrder, Queue<Node> queue) {
        if (queue.isEmpty())
            return lateralOrder;
        Node temp = queue.poll();
        lateralOrder.add(temp.data);
        if (temp.left != null)
            queue.add(temp.left);
        if (temp.right != null)
            queue.add(temp.right);
        return lateralOrderTraversal(root, lateralOrder, queue);
    }

    private static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        }
        return root;

    }
}

class Node {
    int data;
    Node left = null;
    Node right = null;

    public Node(int data) {
        this.data = data;
    }
}