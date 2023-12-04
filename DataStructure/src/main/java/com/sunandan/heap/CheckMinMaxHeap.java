package com.sunandan.heap;

import java.util.Arrays;
import java.util.Collections;

public class CheckMinMaxHeap {

    public boolean checkMinHeap(Integer[] array, int indx){
        if((2*indx + 2) > array.length-1)
            return true;
        boolean left = (array[indx] <= array[2* indx + 1]) && checkMinHeap(array , 2* indx + 1);
        boolean right = (array[indx] <= array[2* indx + 2]) && checkMinHeap(array , 2* indx + 2);

        return left && right;
    }

    public boolean checkMaxHeap(Integer[] array, int indx){
        if((2*indx + 2) > array.length-1)
            return true;
        boolean left = (array[indx] >= array[2* indx + 1]) && checkMaxHeap(array , 2* indx + 1);
        boolean right = (array[indx] >= array[2* indx + 2]) && checkMaxHeap(array , 2* indx + 2);

        return left && right;
    }

    public static void main(String[] args) {
        CheckMinMaxHeap cheap = new CheckMinMaxHeap();
        Integer[] array = {2,3,4,5,10,15};
        if(cheap.checkMinHeap(array, 0))
            System.out.println("It is a Min Heap");
        Arrays.sort(array, Collections.reverseOrder());
        if(cheap.checkMaxHeap(array, 0))
            System.out.println("It is a Max Heap");
    }
}
