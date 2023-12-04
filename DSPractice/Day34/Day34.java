import java.util.Arrays;
import java.util.List;

class Day34 {

    private Node headA;
    private Node headB;

    public static void main(String[] args) {
        Day34 day34 = new Day34();
        day34.createIntersectionPoint(Arrays.asList(4, 1, 8, 4, 5), Arrays.asList(5,6,1,8,4,5), 2, 3);
        System.out.println("Calculate");
        System.out.println("output : " + day34.getIntersection());
    }

    private int getIntersection() {
        Node head1 = headA, head2 = headB;
        while (head1 != head2) {
            head1 = head1 == null ? headB : headA.next;
            head2 = head2 == null ? headA : headB.next;
        }
        return head1.data;
    }

    private void createIntersectionPoint(List<Integer> listA, List<Integer> listB, int skipElementsinListA,
            int skipElementsinListB) {
        headA = new Node(listA.get(0));
        headB = new Node(listB.get(0));
        Node tempA = headA;
        Node tempB = headB;
        for (int i = 1; i <= skipElementsinListA; i++) {
            Node temp = new Node(listA.get(i));
            tempA.next = temp;
            tempA = tempA.next;
        }
        for (int i = 1; i < skipElementsinListB-1; i++) {
            Node temp = new Node(listB.get(i));
            tempB.next = temp;
            tempB = tempB.next;
        }
        tempB.next = tempA;
        for (int i = skipElementsinListA+1; i < listA.size(); i++) {
            Node temp1 = new Node(listB.get(i));
            tempA.next = temp1;
            tempA = tempA.next;
        }
    }

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}