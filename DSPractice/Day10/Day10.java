import java.util.*;
import java.util.stream.Collectors;

/**
 * Day10
 */
public class Day10 {

    public static void main(String[] args) {
        Day10 day10 = new Day10();
        int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        Arrays.stream(day10.merge(input)).forEach((i) -> System.out.println(Arrays.toString(i)));
        int[][] input1 = { { 1, 4 }, { 4, 5 } };
        Arrays.stream(day10.merge(input1)).forEach((i) -> System.out.println(Arrays.toString(i)));
        Arrays.stream(day10.pascal(4)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(day10.pascal(5)).forEach(System.out::print);
        System.out.println();
        day10.getCombinations(Arrays.asList(1, 2, 5), 10).stream().forEach(System.out::println);
    }

    private List<List<Integer>> getCombinations(List<Integer> coinDenominations, int finalAmount) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < coinDenominations.size(); i++) {
            if (coinDenominations.get(i) > finalAmount)
                continue;
            if (coinDenominations.get(i) == finalAmount)
                return new ArrayList<>(
                        Collections.singleton(new ArrayList<>(Collections.singleton(coinDenominations.get(i)))));
            List<Integer> combinations = new ArrayList<>();
            combinations.add(coinDenominations.get(i));
            List<List<Integer>> intermediateCombinations = getCombinations(coinDenominations,
                    finalAmount - coinDenominations.get(i));
            for (List<Integer> c : intermediateCombinations) {
                c.addAll(combinations);
            }
            result.addAll(intermediateCombinations);
        }
        return result.stream().map((i) -> {
            Collections.sort(i);
            return i;
        }).distinct().collect(Collectors.toList());
    }

    private int[][] merge(int[][] input) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(input, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < input.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < input[i][0])
                result.add(input[i]);
            else
                result.getLast()[1] = input[i][1];
        }
        return result.toArray(new int[result.size()][2]);
    }

    private int[] pascal(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                result[j] += result[j - 1];
            }
        }
        return result;
    }

}