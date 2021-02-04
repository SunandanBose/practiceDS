import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Day12
 */
public class Day12 {

    public static void main(String[] args) {
        Day12 day12 = new Day12();
        System.out.println(day12.longestPalindrome("abccccdd"));
        // System.out.println(day12.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        int[][] input = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(day12.nonOverlappingInterval(input));
        int[][] input1 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        System.out.println(day12.nonOverlappingInterval(input1));
        int[][] input2 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        Arrays.stream(day12.mergeInterval(input2)).forEach((i) -> System.out.println(Arrays.toString(i)));
        System.out.println(Arrays.toString(day12.getPascal(5)));
        day12.getCoinChange(Arrays.asList(1, 2, 5), 10).stream().forEach(System.out::println);
    }

    private List<List<Integer>> getCoinChange(List<Integer> coinDenomination, int finalAmount) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer coin : coinDenomination) {
            if (coin > finalAmount) {
                continue;
            }
            if (coin == finalAmount)
                return new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(coin))));
            List<Integer> combinations = new ArrayList<>();
            combinations.add(coin);
            List<List<Integer>> intermidiateCombination = getCoinChange(coinDenomination, finalAmount - coin);
            for (List<Integer> combination : intermidiateCombination) {
                combination.addAll(combinations);
            }
            result.addAll(intermidiateCombination);
        }
        return result.stream().map((list) -> {
            Collections.sort(list);
            return list;
        }).distinct().collect(Collectors.toList());
    }

    private int[] getPascal(int n) {
        int[] pascal = new int[n];
        pascal[0] = 1;
        for (int i = 1; i < pascal.length; i++) {
            for (int j = i; j > 0; j--) {
                pascal[j] += pascal[i - 1];
            }
        }
        return pascal;
    }

    private int[][] mergeInterval(int[][] interval) {
        Arrays.sort(interval, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < interval.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < interval[i][0]) {
                result.add(interval[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[i][1]);
            }

        }
        return result.toArray(new int[result.size()][2]);
    }

    private int longestPalindrome(String input) {
        Map<Character, Integer> freq = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        int oddCount = 0;
        int evenCount = 0;
        for (Character ch : freq.keySet()) {
            int value = freq.get(ch);
            if (value % 2 == 0) {
                System.out.println("even " + ch);
                evenCount += value;
            } else {
                System.out.println("odd " + ch);
                oddCount = Math.max(oddCount, value);
            }
        }
        return evenCount + oddCount;
    }

    private int nonOverlappingInterval(int[][] interval) {
        Arrays.sort(interval, (a, b) -> (a[0] - b[0]));
        int result = 0;
        int min = interval[0][0];
        int max = interval[0][1];
        for (int i = 1; i < interval.length; i++) {
            if ((interval[i][0] > min && interval[i][0] < max) || (interval[i][1] > min && interval[i][1] < max)
                    || min == interval[i][0] || max == interval[i][1])
                result += 1;
            else {
                min = Math.min(interval[i][0], min);
                max = Math.max(interval[i][1], max);
            }

        }
        return result;
    }
}