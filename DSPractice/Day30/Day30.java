import java.util.*;

/**
 * Day30
 */

public class Day30 {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right = new Node(6);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        System.out.println();
        Node clone = cloneTree(head);
        printTree(clone);
    }

    private static void printTree(Node head) {
        if (head == null)
            return;
        printTree(head.left);
        System.out.print(head.data + " ");
        printTree(head.right);
    }

    private static Node cloneTree(Node head) {
        if (head == null)
            return null;
        Node cloneHead = new Node(head.data);
        cloneHead.left = cloneTree(head.left);
        cloneHead.right = cloneTree(head.right);
        return cloneHead;
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