import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int n = s.length();
        if (n == 0)
            return 0;
        int i = 0, j = 0, maxValue = 0;
        while (i < n && j < n) {
            if (window.contains(s.charAt(j)))
                window.remove(s.charAt(i++));
            else {
                window.add(s.charAt(j++));
                maxValue = Math.max(maxValue, j - i);
            }
        }
        return maxValue;
    }
    
}
