import java.util.*;

class Day33 {
    public static void main(String[] args) {
        Day33 day33 = new Day33();
        String str = "catsanddog";
        List<String> dictionary = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(day33.wordBreak(str, dictionary));
        dictionary = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(day33.wordBreak("pineapplepenapple", dictionary));
    }

    private List<String> wordBreak(String str, final List<String> dictionary) {
        List<String> result = new ArrayList<>();
        if (dictionary.contains(str))
            return Collections.singletonList(str);
        for (int i = 1; i < str.length(); i++) {
            String LHS = str.substring(0, i);
            if (dictionary.contains(LHS)) {
                List<String> RHS = wordBreak(str.substring(i), dictionary);
                for (String string : RHS) {
                    result.add(LHS + " " + string);
                }
            }
        }
        return result;
    }
}