
import java.util.*;
import java.util.stream.*;

/**
 * Day9
 */
public class Day9 {
    public static void main(String[] args) {
        Day9 day9 = new Day9();
        System.out.println("Expected : 1 4 6 4 1 Actual : " + day9.getPascalTriangle(5));
        day9.getCombination(Arrays.asList(1, 2, 5), 10).forEach(System.out::println);
        int[] input = { 1, 2, 3, 1 };
        System.out.println("Expected : 4 Actual : " + day9.rob(input));
        int[] input1 = { 2, 7, 9, 3, 1 };
        System.out.println("Expected : 12 Actual : " + day9.rob(input1));
    }

    private int rob(int[] arr) {
        int currRobbed = 0;
        int currNotRobbed = 0;
        int currPrevRobbed = 0;
        int currPrevNotRobbed = 0;
        for (int i = 0; i < arr.length; i++) {
            currRobbed = currPrevNotRobbed + arr[i];
            currNotRobbed = Math.max(currPrevNotRobbed, currPrevRobbed);

            currPrevRobbed = currRobbed;
            currPrevNotRobbed = currNotRobbed;
        }
        return Math.max(currPrevNotRobbed, currPrevRobbed);
    }

    private List<List<Integer>> getCombination(List<Integer> coinDenomination, int finalAmount) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < coinDenomination.size(); i++) {
            if (coinDenomination.get(i) > finalAmount)
                continue;
            if (coinDenomination.get(i) == finalAmount)
                return new ArrayList<>(
                        Collections.singleton(new ArrayList<>(Collections.singletonList(coinDenomination.get(i)))));
            List<Integer> combinations = new ArrayList<>();
            combinations.add(coinDenomination.get(i));
            List<List<Integer>> intermidiateList = getCombination(coinDenomination,
                    finalAmount - coinDenomination.get(i));
            for (List<Integer> combination : intermidiateList) {
                combination.addAll(combinations);
            }
            result.addAll(intermidiateList);
        }
        return result.stream().map((i) -> {
            Collections.sort(i);
            return i;
        }).distinct().collect(Collectors.toList());
    }

    private String getPascalTriangle(int n) {
        int[] pascal = new int[n];
        pascal[0] = 1;
        int index = 1;
        while (index < n) {
            for (int i = index; i > 0; i--) {
                pascal[i] = pascal[i] + pascal[i - 1];
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(pascal).forEach((i) -> sb.append(i + " "));
        return sb.toString();
    }
}