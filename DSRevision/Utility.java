import java.util.List;

public class Utility {
    
    public static void printASectionOfAnArray(int[] array, int start, int end) {
        for(int i = start; i < end; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode createIntegerListNode(List<Integer> list) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for(Integer i: list) {
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = node.next;
        }
        return head.next;
    }
}
