import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestConsecutiveSequence = 0;
        for(Integer num : numsSet){
            int count = 1;
            int value = num;
            if(numsSet.contains(value - 1))
                continue;
            while(numsSet.contains(value + 1)){
                value += 1;
                count += 1;
            }
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
        }
        return longestConsecutiveSequence;
    }
}