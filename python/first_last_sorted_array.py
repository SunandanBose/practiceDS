# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        answer = [-1, -1]
        if not nums:
            return answer
        
        currentLeft = self.binarySearch(nums, target, 0, len(nums) - 1)
        currentRight = currentLeft
        
        while currentLeft != -1:
            if currentLeft != -1:
                answer[0] = currentLeft
            currentLeft = self.binarySearch(nums, target, 0, currentLeft - 1)
            
        while currentRight != -1:
            if currentRight != -1:
                answer[1] = currentRight
            currentRight = self.binarySearch(nums, target, currentRight + 1, len(nums) - 1)
            
        return answer
        
    def binarySearch(self, nums: List[int], target: int, left, right) -> List[int]:
        while left <= right:
            mid = (left + right) // 2
            if target == nums[mid]:
                return mid
            if target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
                
        return -1 
        
        