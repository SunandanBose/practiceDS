# https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/

# Logic
# For 0 and 1 hardcode
# For 2 and more
# Have 2 indexes, one for the unique numbers and one for the iterator
# Use the iterator index to iterate over all the numbers
# Use the unique index to only move when you find a unique number
# Move the unique number to the unique index

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) < 2:
            return 1
        unique_element_index = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                pass
            else:
                nums[unique_element_index] = nums[i]
                unique_element_index = unique_element_index + 1
            
        return unique_element_index
            
