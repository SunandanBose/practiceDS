package com.sunandan.permutation;

import com.sunandan.google.InterLeaveString;

import java.util.Set;
import java.util.TreeSet;

public class StringCombinationIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 && k <= 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor(1L * nums[i] + t);
            Long ceil = set.ceiling(1L * nums[i] - t);
            if (floor != null && nums[i] <= floor || ceil != null && nums[i] >= ceil) {
                return true;
            }
            set.add(1L * nums[i]);
            if (i >= k) {
                set.remove(1L * nums[i - k]);
            }
        }
        return false;
    }

}
