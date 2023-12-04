import java.util.*;

/**
 * Day22
 */
public class Day22 {

    public static void main(String[] args) {
        Day22 day22 = new Day22();
        int[] input = { 2, 35, 4, 34, 6, 33 };
        System.out.println(day22.threeSum(input, 40));
    }

    private boolean threeSum(int[] input, int sum) {
        Arrays.sort(input);
        for (int first = 0; first < input.length - 2; first++) {
            int middle = first + 1;
            int last = input.length - 1;
            while (middle < last && first < last) {
                int calculatedSum = input[first] + input[middle] + input[last];
                if (calculatedSum == sum) {
                    System.out.println(input[first] + " : " + input[middle] + " : " + input[last]);
                    return true;
                }
                if (calculatedSum < sum)
                    middle++;
                if (calculatedSum > sum)
                    last--;
            }
        }
        return false;
    }

}