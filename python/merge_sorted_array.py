# https://leetcode.com/problems/merge-sorted-array/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # Last index
        k = m + n - 1
        m -= 1
        n -= 1
        
        
        while True:
            # Exit when either array is over
            if m < 0 or n < 0:
                break
            
            # Fill in whichever number is greater at the end
            if nums1[m] > nums2[n]:
                nums1[k] = nums1[m]
                nums1[m] = 0
                m -= 1
            else:
                nums1[k] = nums2[n]
                n -= 1
            
            k -= 1
        
        # Back fill nums2 or nums1 whichever is left
        while n >= 0:
            nums1[k] = nums2[n]
            n -= 1
            k -= 1
        
        while m >= 0:
            nums1[k] = nums1[m]
            m -= 1
            k -= 1
        
