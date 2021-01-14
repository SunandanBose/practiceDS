import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Day8
 */
public class Day8 {

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        List<List<Integer>> combinations = day8.coinChangeProblem(Arrays.asList(1, 2, 5), 10);
        combinations.forEach(System.out::println);
        System.out.println("expected value : 8 Actual value : " + day8.climbStairs(5));
        System.out.println("expected value : 8 Actual value : " + day8.climbStairsDP(5));
    }

    private List<List<Integer>> coinChangeProblem(List<Integer> coinDenomination, int finalAmount) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer coin : coinDenomination) {
            if (coin > finalAmount)
                continue;
            if (coin == finalAmount)
                return new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(coin))));
            List<Integer> comnbination = new ArrayList<>();
            comnbination.add(coin);
            List<List<Integer>> intermediateList = coinChangeProblem(coinDenomination, finalAmount - coin);
            for (List<Integer> list : intermediateList) {
                list.add(coin);
                Collections.sort(list);
            }
            result.addAll(intermediateList);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n < 3)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private int climbStairsDP(int n) {
        if (n == 0)
            return 0;
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }
}