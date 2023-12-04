class Node:
    def __init__(self, element, next) -> None:
        self.element = element
        self.next = next

def init():
    head = Node(1, None)
    head.next = Node(2, None)
    head.next.next = Node(3, None)
    head.next.next.next = Node(4, None)
    head.next.next.next.next = Node(5, None)
    return(head)

# list = Node().init()

def reverse(head):
    prev_node = None
    current = head

    while current is not None:
        next_node = current.next
        current.next = prev_node

        prev_node = current
        current = next_node
    
    head = prev_node
    return head


def printList(head):
    while head is not None:
        print (head.element)
        head = head.next

printList(reverse(init()))