import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WordBreak
 */
public class WordBreak {

    Map<String, Boolean> visited = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(visited.get(s) != null)
            return visited.get(s);
        if(wordDict.contains(s))
            return true;
        if(s.length() == 1)
            return false;
        for(int i = 1; i < s.length(); i++) {
            String leftString = s.substring(0,i);
            boolean left = wordBreak(leftString, wordDict);
            if(left) {
                visited.put(leftString, left);
                String rightString = s.substring(i);
                boolean right = wordBreak(rightString, wordDict);
                if (right) {
                    visited.put(rightString, right);
                    return true;
                }   
            }
        }
        return false;
    }
}