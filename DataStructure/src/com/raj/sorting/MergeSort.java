// package com.raj.sorting
import java.util.*;
class MergeSort{
    public static void main(String[] args) {
        System.out.println("Hello World");

        List<Integer> x = new ArrayList(Arrays.asList(2,1,4,3,-2,56));        
        mergeSort(x);
        System.out.println(x);
    }


    // 1,2 13,16

    private static void mergeSort(List<Integer> list){
        // recurse until single element is left -> done
        // Get left and right from list -> done
        // Recurse -> done
        if (list.size() <= 1){
            return;
        }
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList(list.subList(0, mid));
        List<Integer> right = new ArrayList(list.subList(mid, list.size()));
        mergeSort(left);
        mergeSort(right);

        int leftIndex = 0;
        int rightIndex = 0;
        int resultListIndex = 0;
        
        // merge left and right

        while(leftIndex < left.size() || rightIndex < right.size()){
            System.out.println(left);
            System.out.println(right);
            if (leftIndex == left.size() || rightIndex == right.size()){
                break;
            }
            if (left.get(leftIndex) < right.get(rightIndex)){
                list.set(resultListIndex++, left.get(leftIndex++));
                continue;
            }
            if (left.get(leftIndex) > right.get(rightIndex)){
                list.set(resultListIndex++, right.get(rightIndex++));
                continue;
            }
        }
        if(leftIndex != left.size()){
            for (int i = leftIndex; i < left.size(); i++) {
                list.set(resultListIndex++, left.get(leftIndex++));
            }
        }
        if(rightIndex != right.size()){
            for (int i = rightIndex; i < right.size(); i++) {
                list.set(resultListIndex++, right.get(rightIndex++));
            }
        }
    }
}
