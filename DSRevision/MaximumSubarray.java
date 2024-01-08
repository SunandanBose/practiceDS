import java.util.ArrayList;
import java.util.List;

/**
 * MaximumSubarray
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int currentSum = nums[0];
        List<Integer> currentSubArray = new ArrayList<>();
        for(int i = 1; i < nums.length; i++) {
            if((currentSum + nums[i]) < nums[i] ){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                currentSubArray = temp;
                currentSum = nums[i];
                maxValue = Math.max(currentSum, maxValue);
                continue;
            }
            currentSum += nums[i];
            currentSubArray.add(nums[i]);
            maxValue = Math.max(currentSum, maxValue);
        }
        return maxValue;    
    }
}