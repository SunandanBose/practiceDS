package com.sunandan.Map;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyDeQueue<T> {

    private DeQueueNode head = null;

    private DeQueueNode tail = null;

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public boolean add(T input) {
        addLast(input);
        return true;
    }

    public void addFirst(T input) {
        DeQueueNode<T> first = head;
        DeQueueNode<T> newNode = new DeQueueNode(null, input, first);
        head = newNode;
        if (first == null)
            tail = newNode;
        else
            first.prev = newNode;
        size++;
    }

    public void addLast(T input) {
        DeQueueNode<T> last = tail;
        DeQueueNode<T> newNode = new DeQueueNode(last, input, null);
        tail = newNode;
        if (last == null)
            head = newNode;
        else
            last.next = newNode;
        size++;
    }

    public T removeFirst() {
        DeQueueNode<T> first = head;
        if (first == null)
            throw new NoSuchElementException();
        T elem = first.value;
        DeQueueNode<T> next = first.next;
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        return elem;
    }

    public T removeLast() {
        DeQueueNode<T> last = tail;
        if (last == null)
            throw new NoSuchElementException();
        T elem = last.value;
        DeQueueNode<T> prev = last.prev;
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return elem;
    }

    public T remove() {
        return removeFirst();
    }

    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        DeQueueNode<T> node = head;
        output.append("[");
        if (node != null) {
            String prefix = "";
            while (node != null) {
                output.append(prefix + "" + String.valueOf(node.value));
                prefix = ", ";
                node = node.next;
            }
        }
        output.append("]");
        return output.toString();
    }
}

class DeQueueNode<T> {

    T value;
    DeQueueNode prev;
    DeQueueNode next;

    DeQueueNode(DeQueueNode<T> prev, T value, DeQueueNode<T> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
