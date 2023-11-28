public class RemoveDuplicatesSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesSortedArrayII removeDuplicatesSortedArrayII = new RemoveDuplicatesSortedArrayII();
        int[] nums = {1,1,1,1,1,2,2,3};
        //expected 1,1,2,2,3
        int result = removeDuplicatesSortedArrayII.removeDuplicates(nums);
        Utility.printASectionOfAnArray(nums, 0, result);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            // As the values are sorted so the value of the nth element cannot be same as the value of the n-2th element.
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
