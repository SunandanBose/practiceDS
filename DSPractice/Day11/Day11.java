import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;

/**
 * Day11
 */
public class Day11 {

    public static void main(String[] args) {
        Day11 day11 = new Day11();
        int[][] input = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(day11.nonOverLappingInterval(input));
        System.out.println();
        int[][] input1 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        System.out.println(day11.nonOverLappingInterval(input1));
        int[][] interval = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        Arrays.stream(day11.mergeInterval(interval)).forEach((i) -> System.out.println(Arrays.toString(i)));
        System.out.println(Arrays.toString(day11.getPascal(5)));
        day11.coinChangeProblem(Arrays.asList(1,2,5), 10).stream().forEach(System.out::println);
    }

    private List<List<Integer>> coinChangeProblem(List<Integer> coinDenomination, int finalAmount) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer coin : coinDenomination) {
            if(coin > finalAmount)
                continue;
            if(coin == finalAmount)
                return new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(coin))));
            List<Integer> combinations = new ArrayList<>();
            combinations.add(coin);
            List<List<Integer>> intermediateCombination = coinChangeProblem(coinDenomination, finalAmount-coin);
            for(List<Integer> combination : intermediateCombination){
                combination.addAll(combinations);
            }
            result.addAll(intermediateCombination);
        }
        return result.stream().map((i) -> {
            Collections.sort(i);
            return i;
        }).distinct().collect(Collectors.toList());
    }

    private int[] getPascal(int n) {
        int[] pascal = new int[n];
        pascal[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                pascal[j] += pascal[j - 1];
            }
        }
        return pascal;
    }

    private int[][] mergeInterval(int[][] interval) {
        Arrays.sort(interval, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < interval.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < interval[i][0])
                result.add(interval[i]);
            result.getLast()[1] = Math.max(interval[i][1], result.getLast()[1]);
        }

        return result.toArray(new int[result.size()][2]);
    }

    private int nonOverLappingInterval(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (isWithinRange(intervals[i][0], min, max) || isWithinRange(intervals[i][1], min, max)
                    || min == intervals[i][0] || max == intervals[i][1]) {
                result += 1;
            } else {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(min, intervals[i][1]);
            }
        }
        return result;
    }

    private boolean isWithinRange(int value, int min, int max) {
        if (value > min && value < max)
            return true;
        return false;
    }

}