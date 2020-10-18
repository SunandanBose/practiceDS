package com.sunandan.Random;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        int[] mergedArray = new int[nums1.length+nums2.length];
        while(leftIndex < nums1.length && rightIndex < nums2.length){
            if(nums1[leftIndex] < nums2[rightIndex]){
                mergedArray[count++] = nums1[leftIndex++];
            }
            else{
                mergedArray[count++] = nums2[rightIndex++];
            }
        }
        for(int i = leftIndex; i < nums1.length ; i++){
            mergedArray[count++] = nums1[i];
        }
        for(int i = rightIndex; i < nums2.length ; i++){
            mergedArray[count++] = nums2[i];
        }
        int mergedArraySize = nums1.length+nums2.length;
        if(mergedArraySize%2 == 0)
            return (double)(mergedArray[mergedArraySize/2]+mergedArray[(mergedArraySize/2)-1])/2;
        return (double)mergedArray[mergedArraySize/2];
    }

}
