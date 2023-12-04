import java.util.Arrays;

/**
 * MajorityElements
 */
public class MajorityElements {

    public static void main(String[] args) {
        MajorityElements majorityElements = new MajorityElements();
        int[] nums = {2,2,1,1,1,2,2};
        int element = majorityElements.majorityElement(nums);
        System.out.println(element);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    

}

