import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ThreeSum
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            int j = i + 1;
            int k = length - 1;
            if(nums[i] > 0) continue;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) 
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }
        }
        return new ArrayList(result);
    }

}