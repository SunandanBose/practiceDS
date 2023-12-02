import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    
    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted();
        int[] nums = {2,7,11,15};
        int[] output = twoSumIIInputArrayIsSorted.twoSum(nums, 9);
        System.out.println(Arrays.toString(output));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while(leftIndex < rightIndex){
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if(sum == target){
                output[0] = leftIndex + 1;
                output[1] = rightIndex + 1;
                return output;
            }
            if(sum < target)
                leftIndex++;
            if(sum > target)
                rightIndex--;
        }
        return output;
    }



}
