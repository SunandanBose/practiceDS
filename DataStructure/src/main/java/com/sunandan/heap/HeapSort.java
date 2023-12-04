package com.sunandan.heap;

public class HeapSort {

    public void heapify(int[] array, int max_length, int index){
        int largest = index;
        int left  = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < max_length && (array[left] <= array[largest])){
            largest = left;
        }
        if(right < max_length && (array[right] <= array[largest])){
            largest = right;
        }
        if(largest != index){
            array = swap(array, index, largest);
            heapify(array, max_length, largest);
        }
    }

    public void sort(int[] array){
        int n = array.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(array,n,i);
        }
        for(int i= n-1;i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i]=temp;
            heapify(array,i,0);
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
        int[] array = {5,1,6,4,8,3};
        hs.sort(array);
    }
}
