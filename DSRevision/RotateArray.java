import java.util.Arrays;

public class RotateArray {
    
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {5,6,7,1,2,3,4};
        rotateArray.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (k > nums.length) 
            k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
