import java.io.*;
import java.util.*;

/**
 * Day29
 */
public class Day29 {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("a", 1);
        pq.add("e", 5);
        pq.add("d", 4);
        pq.add("f", 6);
        pq.add("g", 7);
        pq.add("h", 8);
        pq.add("c", 3);
        pq.add("b", 2);
        for (int i = 0; i < 8; i++) {
            System.out.println(pq.remove().toString());
        }
    }
}

class PriorityQueue<T> {

    private List<PriorityNode<T>> items = null;
    private int size = 0;

    public PriorityQueue() {
        items = new ArrayList<PriorityNode<T>>();
    }

    public void add(T value, int priority) {
        PriorityNode<T> node = new PriorityNode<T>(value, priority);
        items.add(node);
        size++;
        arrange();
    }

    private void arrange() {
        int current = size - 1;
        int parent = current / 2;
        while (parent > 0) {
            if (items.get(parent).priority > items.get(current).priority) {
                swap(parent, current);
                current = parent;
                parent = current / 2;
                continue;
            }
            break;
        }
    }

    public T remove() {
        PriorityNode<T> nodeToRemove = items.get(0);
        PriorityNode<T> nodeToMove = items.remove(size - 1);
        size--;
        if (size >= 1)
            items.set(0, nodeToMove);
        rearrange();
        return nodeToRemove.value;
    }

    private void rearrange() {
        int current = 0;
        while (current < size) {
            int left_child = (2 * current) + 1;
            int right_child = (2 * current) + 2;
            int urgent = left_child;
            if (left_child < size && right_child < size
                    && items.get(left_child).priority > items.get(right_child).priority) {
                urgent = right_child;
            }
            if (urgent < size && items.get(urgent).priority < items.get(current).priority) {
                swap(urgent, current);
                current = urgent;
            } else {
                break;
            }
        }
    }

    private void swap(int parent, int current) {
        PriorityNode<T> temp = items.get(parent);
        items.set(parent, items.get(current));
        items.set(current, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).toString());
            sb.append(" ");
        }
        return sb.toString();
    }

}

class PriorityNode<T> {
    T value;
    int priority;

    public PriorityNode(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}