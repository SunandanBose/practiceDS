import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Day13
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 day13 = new Day13();
        Integer[] height = {2,1,5,6,2,3};
        int maxArea = day13.largestRectangle(height);
        System.out.println(maxArea);
    }

    private int largestRectangle(Integer[] height) {
        int maxArea = Integer.MIN_VALUE;
        List<Integer> uniqueValues = Arrays.stream(height).filter((i) -> i!=0).distinct().sorted().collect(Collectors.toList());
        for(Integer i : uniqueValues){
            int sum = 0;
            int maxSum = 0;
            for (int j = 0; j < height.length; j++) {
                sum += i;
                if(height[j] < i)
                    sum = 0;
                maxSum = Math.max(maxSum, sum);
            }
            maxArea = Math.max(maxArea, maxSum);
        }
        return maxArea;
    }
}