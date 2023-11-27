import java.util.Arrays;

public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        int[] nums = {0,1,2,2,3,0,4,2};
        int value = removeElements.removeElement(nums, 2);
        System.out.println(value);
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int length = nums.length;
        while(fast < length) {
            if(nums[fast] == val){
                fast ++;
                continue;
            }
            nums[slow] = nums[fast];
            slow ++;
            fast ++;
        }
        return slow;
    }
}
