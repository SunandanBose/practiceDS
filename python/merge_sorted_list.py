# https://leetcode.com/problems/merge-two-sorted-lists/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        list3 = ListNode()
        head = list3

        # Logic
        # iterate over list1 and list2
        # if list1 is empty and list2 is not empty add list2
        # if list2 is empty and list1 is not empty add list1

        # if list1 < list2
            # add list1
        # else add list2
         
        while list1 is not None or list2 is not None:
            if list1 is None and list2 is not None:
                    list3.next = list2
                    return head.next

            if list2 is None and list1 is not None:
                    list3.next = list1
                    return head.next
            
            if list1.val < list2.val:
                list3.next = list1
                list1 = list1.next
            else:
                list3.next = list2
                list2 = list2.next
            list3 = list3.next

        return head.next