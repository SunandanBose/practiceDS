# https://leetcode.com/problems/two-sum/

nums = [2,7,11,15]
target = 9


# O[n2]
def two_sum_1(numbers: list[int], target: int) -> list[int]:
	for i in range(0, len(numbers)):
		for j in range(i+1, len(numbers)):
			if numbers[i] + numbers[j] == target:
				return[numbers[i],numbers[j]]

	return []

# O[1]
# We are saving all numbers in a map
# Checking if current number minus the target is already in the map
# if yes, return it.
def two_sum_2(numbers: list[int], target: int) -> list[int]:
	tracker_dict = {}
	for i in range(0, len(numbers)):
		if (target - numbers[i]) in tracker_dict:
			return [i, tracker_dict[target - numbers[i]]]
		tracker_dict[numbers[i]] = i

	return []

print(two_sum_1(nums, target))

