package com.sunandan.heap;

import java.util.PriorityQueue;

public class KthLargestInMatrix {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue pq = new PriorityQueue();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k)
                pq.poll();
        }
        return (int)pq.peek();
    }

}
