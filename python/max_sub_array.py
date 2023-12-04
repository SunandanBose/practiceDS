# https://leetcode.com/problems/maximum-subarray/submissions/
# Also called kadane's algorithm

# Initialise to first element the sums
# In the case of a negative number if it reduces the sum to be less than the number itself then
# Start a new sub array with a fresh sum called current_sum
# else continue adding the numbers to the sums.
# Have a max_sum and compare and return the values.

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        current_sum = max_sum = nums[0]

        for num in nums[1:]:
            if (current_sum + num) > num:
                current_sum = current_sum + num
            else: current_sum = num

            if current_sum > max_sum:
                max_sum = current_sum
        return max_sum
