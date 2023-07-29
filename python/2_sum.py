# https://leetcode.com/problems/two-sum/

nums = [2,7,11,15]
target = 9


def two_sum(numbers: list[int], target: int) -> list[int]:
	for i in range(0, len(numbers)):
		for j in range(i+1, len(numbers)):
			if numbers[i] + numbers[j] == target:
				return[numbers[i],numbers[j]]

	return []

print(two_sum(nums, target))