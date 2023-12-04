# https://leetcode.com/problems/container-with-most-water/

def container_with_most_water(height: List[int]) -> int:
	
	# Start from the widest container i.e. start and end
	# Move inward but from the one that is smaller
	# see the current water level and replace it with max or keep max

	max_water = 0
	i = 0
	j = len(height) - 1
	while i < j:
		current_water = (j - i) * min(height[i], height[j])
		max_water = max(current_water, max_water)

		if height[i] < height[j]:
			i += 1
		else:
			j -= 1

	return max_water