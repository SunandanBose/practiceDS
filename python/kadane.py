class Solution:
    
    def maxSubArray(self, nums: List[int]) -> int:
        # Initialize a current sum and a max sum
        currentSum = nums[0]
        maxSum = currentSum
        # Exit if empty
        if not nums:
            return 0

        for num in nums[1:]:
            # If currentSum is negative - reset
            if num > (num + currentSum):
                currentSum = num
            else: 
                currentSum += num # Calculate current sum
            if currentSum > maxSum:
                maxSum = currentSum # Calculate max sum
        return maxSum
