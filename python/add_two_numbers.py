from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        num1 = ''
        num2 = ''
        while (l1 is not None):
            num1 = num1 + str(l1.val)
            l1 = l1.next
        while (l2 is not None):
            num2 = num2 + str(l2.val)
            l2 = l2.next

        num1 = num1[::-1]
        num2 = num2[::-1]
        sum = int(num1) + int(num2)
        head = ListNode(int(sum%10), None)
        sum = int(sum / 10)
        res = head
        while (sum != 0):
            res.next = ListNode(int(sum%10), None)
            res = res.next
            sum = int(sum / 10)

        return head


l1 = ListNode(2, None)
l1.next = ListNode(4, None)
l1.next.next = ListNode(3, None)

l2 = ListNode(5, None)
l2.next = ListNode(6, None)
l2.next.next = ListNode(4, None)


sol = Solution().addTwoNumbers(l1, l2)
while (sol is not None):
    print(sol.val)
    sol = sol.next
