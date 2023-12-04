public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
        int[] input = {1,1,2,2,2,3,4,4,4,5,5};
        int k = removeDuplicatesSortedArray.removeDuplicates(input);
        for(int i = 0; i < k; i++) {
            System.out.print(input[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }

}
