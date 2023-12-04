package com.sunandan.heap;

import java.util.Arrays;

public class PriorityQueue {

    private PriorityNode[] priorityQueue = new PriorityNode[10];
    private int size = 1;

    public void add(String value, int priority) {
        PriorityNode<String> nodeToAdd = new PriorityNode<>(value, priority);
        priorityQueue[size++] = nodeToAdd;
        this.arrange();
    }

    private void arrange() {
        int current = size - 1;
        int parent = (current) / 2;
        while (parent > 0) {
            if (priorityQueue[parent].priority > priorityQueue[current].priority) {
                this.swap(parent, current);
                current = parent;
                parent = current / 2;
                continue;
            }
            break;
        }
    }

    private void swap(int index1, int index2) {
        PriorityNode temp = priorityQueue[index1];
        priorityQueue[index1] = priorityQueue[index2];
        priorityQueue[index2] = temp;
    }

    public PriorityNode remove() {
        PriorityNode DeletedObject = priorityQueue[1];
        priorityQueue[1] = priorityQueue[size - 1];
        priorityQueue[size - 1] = null;
        size--;
        this.rearrange();

        return DeletedObject;
    }

    private void rearrange() {
        int current = 1;
        while(current < size){
            int left_child = 2* current;
            int right_child = 2 * current +1;
            int urgent = left_child;
            if(left_child <= size && right_child <= size && priorityQueue[left_child].priority > priorityQueue[right_child].priority)
                urgent = right_child;
            if(urgent <= size && priorityQueue[urgent].priority < priorityQueue[current].priority){
                swap(urgent, current);
                current = urgent;
            }
            else{
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(priorityQueue);
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
        return String.valueOf(priority);
    }
}
