/**
 * Day27
 */
public class Day27 {

    public static void main(String[] args) {
        Day27 day27 = new Day27();
        System.out.println(day27.maxDiameter(new Node(1)));
    }

    private int maxDiameter(Node head) {
        int max = 0;
        if (head == null)
            return 0;
        max = Math.max(max, height(head.left) + height(head.right));
        maxDiameter(head.left);
        maxDiameter(head.right);
        return max;
    }

    private int height(Node head) {
        if (head == null)
            return 0;
        return 1 + Math.max(height(head.left), height(head.right));
    }
}

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }
}