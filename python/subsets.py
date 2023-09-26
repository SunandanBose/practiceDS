# https://leetcode.com/problems/subsets/


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Start with empty array - [[]]
        # One outer loop for all elements in the array [1,2,3]
        # Second inner loop to move through every element in the current results 
        # [[]] -> [[], [1]] -> [[],[1],[2],[1,2]] -> [[],[1],[2],[1,2],[3],[1,3], [2,3],[1,2,3]]
        # append outer loop element to every element in the results
        # Add all elements from inner loop back to outer loop
        # return
        results = [[]]
        for el in nums:
            current_subsets = []
            for result in results:
                new_result = result.copy()
                new_result.append(el)
                current_subsets.append(new_result)
            

            results.extend(current_subsets)

        return results
            