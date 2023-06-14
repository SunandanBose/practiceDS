class Node:
    def __init__(self, element, next) -> None:
        self.element = element
        self.next = next

def createList():
    head = Node(1, None)
    head.next = Node(2, None)
    head.next.next = Node(3, None)
    head.next.next.next = Node(4, None)
    # head.next.next.next.next = Node(5, None)
    return(head)

def printList(head):
    while head is not None:
        print (head.element)
        head = head.next

def findMiddleElement(head):
    slow_ptr = head
    fast_ptr = head

    while fast_ptr is not None and fast_ptr.next is not None:
        slow_ptr = slow_ptr.next
        fast_ptr = fast_ptr.next.next

    return slow_ptr
    


printList(createList())
print(findMiddleElement(createList()).element)