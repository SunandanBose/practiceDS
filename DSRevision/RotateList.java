import java.util.Arrays;

public class RotateList {
    
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = Utility.createIntegerListNode(Arrays.asList(1,2,3,4,5));
        ListNode result = rotateList.rotateRight(head, 2);
        Utility.printLinkedList(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int lengthOfLinkedList = 1;
        while(temp.next != null) {
            temp = temp.next;
            lengthOfLinkedList ++;
        }
        k = k % lengthOfLinkedList;
        temp.next = head;
        int travelLength = lengthOfLinkedList - k - 1;
        while(travelLength > 0) {
            travelLength --;
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}
