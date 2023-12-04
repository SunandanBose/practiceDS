# https://leetcode.com/problems/remove-nth-node-from-end-of-list/

# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
	# Put all elements in stack
	# Pop all elements back into a list, but skip n while reducing from end
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
    	stack = []
    	while head is not None:
    		stack.append(head.val)
    		head = head.next
    	
    	resultHead = None
    	while stack:
    		if n == 1:
    			stack.pop()
    			n = n - 1
    			continue
    		previous = ListNode(stack.pop(), resultHead)
    		resultHead = previous

    	return resultHead