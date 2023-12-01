import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String str : strs) {
            String sortedString = getStringInAlpabeticalOrder(str);
            if(map.get(sortedString) == null)
                map.put(sortedString, new ArrayList<String>());
            List<String> values = map.get(sortedString);
            values.add(str);
            map.put(sortedString, values);
        }
        Set<String> keySet = map.keySet();
        for(String s: keySet){
            result.add(map.get(s));
        }
        return result;
    }

    public String getStringInAlpabeticalOrder(String str) {
        char[] chArray = str.toCharArray();
        Arrays.sort(chArray);
        return new String(chArray);
    }
}
