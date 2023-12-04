/**
 * MinimumSizeSubarraySum
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int startPointer = 0;
        int endPointer = 0;
        int sum = 0;
        while(endPointer < nums.length){
            sum += nums[endPointer++];
            while(sum >= s){
                ans = Math.min(ans, endPointer-startPointer);
                sum -= nums[startPointer++];
            }
            
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}