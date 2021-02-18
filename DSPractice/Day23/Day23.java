import java.util.*;
/**
 * Day23
 */
public class Day23 {

    public static void main(String[] args) {
        Day23 day23 = new Day23();
        int[] input = {1,33,34,2,3,36};
        System.out.println(day23.threeSum(input, 41));
        Node head = insert(Arrays.asList(1,2,3,4,5,6), 1);
        day23.findLinkedListCycleLocation(head);
    }

	private void findLinkedListCycleLocation(Node head) {
		Node slow = head;
        Node fast = head;
        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                System.out.println("cycle");
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                System.out.println(slow.data);
                break;
            }
        }
        // return null;
	}

	private static Node insert(List<Integer> list, int position) {
        Node head = new Node(list.get(0));
        Node prev = head;
        Node cycle = null;
        for (int i = 1; i < list.size(); i++) {
            Node temp = new Node(list.get(i));
            prev.next = temp;
            prev = temp;
            if(position == i)
                cycle = temp;
        }
        prev.next = cycle;
		return head;
	}

	private boolean threeSum(int[] input, int sum) {
        Arrays.sort(input);
        for (int first = 0; first < input.length; first++) {
            int middle = first + 1;
            int last = input.length - 1;
            while(middle < last && first < last){
                int calculate = input[first] + input[middle] + input[last];
                if(calculate == sum) return true;
                if(calculate < sum) middle ++;
                if(calculate > sum) last --;
            }
        }
		return false;
	}
}

/**
 * Node
 */
class Node {
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
}