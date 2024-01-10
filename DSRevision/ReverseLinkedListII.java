/**
 * ReverseLinkedListII
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        for(int i = 1; i < left; i++)
            prev = prev.next;
        
        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return temp.next;
    }
    
}