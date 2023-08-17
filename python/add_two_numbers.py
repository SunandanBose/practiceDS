# https://leetcode.com/problems/add-two-numbers/description/

# Adding 2 numbers represented as lists

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(0, None)
        result = head
        extra = 0

        while extra or l1 or l2:
            stack1_pop = l1.val if l1 else 0
            stack2_pop = l2.val if l2 else 0
            sum = extra + stack1_pop + stack2_pop
            extra = 0
            if sum > 9:
                extra = 1
                sum = sum % 10
            
            result.next = ListNode(sum, None)
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2
            result = result.next
            
        return head.next
