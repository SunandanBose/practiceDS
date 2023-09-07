# https://leetcode.com/problems/permutations/

from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []
        self.backtrack(answer, [], nums)
        return answer

    def backtrack(self, answer: List[List[int]], templist: List[int], nums: List[int]):
        if len(templist) == len(nums):
            answer.append(templist.copy())
            return
        for num in nums:
            if num in templist:
                continue
            templist.append(num)
            self.backtrack(answer, templist, nums)

            templist.pop()

print(Solution().permute([1,2,3]))


from collections import deque
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        q = deque()
        q.append([nums[0]])
        # Initialise with 1 element
        # Use a queue and when all elements are processed return the list.
        while len(q[0]) != len(nums):
            index = len(q[0])
            # Pop element of queue
            currentElement = q.popleft()
            
            # Take the next entry from nums, and place it in all possible places of the currentElement
            # e.g. [1] -> [2,1], [1,2]
            # explode the list and add it back to the queue.
            for i in range(index + 1):
                currentElementCopy = currentElement.copy()
                currentElementCopy.insert(i, nums[index])
                
                q.append(currentElementCopy)
        
        return q
