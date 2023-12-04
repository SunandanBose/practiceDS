import java.util.*;
import java.util.stream.Collectors;

/**
 * Day20
 */
public class Day20 {
    public static void main(String[] args) {
        Day20 day20 = new Day20();
        int[] input = { 1, 2, 3, 1, 2, 1, 2, 1, 3, 4, 5 };
        System.out.println(day20.findMostFequencyElements(input));
        System.out.println(day20.findLongestPalindromicSubstringInAString("gacbcaj"));
    }

    private String findLongestPalindromicSubstringInAString(String str) {
        List<String> palindromicStrings = new ArrayList<>();
        palindromicStrings = findLongestPalindromicSubstringInAString(str, palindromicStrings);
        Collections.sort(palindromicStrings);
        return palindromicStrings.get(palindromicStrings.size()-1);
    }

    private List<String> findLongestPalindromicSubstringInAString(String input, List<String> result) {
        System.out.println(input);
        if (input.length() == 1)
            return Collections.singletonList(input);
        if (isPalindrome(input)){
            System.out.println("Palindrome" + input);
            result.add(input);
        }
        else {
            result.addAll(findLongestPalindromicSubstringInAString(input.substring(1, input.length()), result));
            result.addAll(findLongestPalindromicSubstringInAString(input.substring(0, input.length() - 1), result));
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    private List<Integer> findMostFequencyElements(int[] input) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(input).forEach(i -> frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1));
        result = Arrays.stream(input).boxed().sorted((a,
                b) -> frequencyMap.get(a) != frequencyMap.get(b) ? frequencyMap.get(b) - frequencyMap.get(a) : (b - a))
                .collect(Collectors.toList());
        return result;
    }
}