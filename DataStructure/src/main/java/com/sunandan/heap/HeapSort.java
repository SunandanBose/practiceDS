package com.sunandan.heap;

public class HeapSort {

    public void heapify(int[] array, int index){
        int largest = index;
        int left  = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < array.length && (array[index] <= array[2* index + 1])){
            largest = left;
        }
        if(right < array.length && (array[index] <= array[2* index + 2])){
            largest = right;
        }
        if(largest != index){
            array = swap(array, index, largest);
            heapify(array, largest);
        }
    }

    public void sort(int[] array){
        int n = array.length;
        for(int i=(n/2)-1;i>=0;i--){
            heapify(array,i);
        }
        print(array);
    }

    private int[] swap(int[] array, int index, int largest) {
        int temp       = array[index];
        array[index]   = array[largest];
        array[largest] = temp;
        return array;
    }

    void print(int[] array){
        for(int i = 0 ; i< array.length ; i++){
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] array = {5,6,1,4,88,3};
        hs.sort(array);
    }
}
