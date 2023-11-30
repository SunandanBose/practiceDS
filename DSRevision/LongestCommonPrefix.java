public class LongestCommonPrefix {
    
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char toCheck;
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            toCheck = strs[0].charAt(i);
            count = 0;
            for(String str: strs){
                int length = str.length();
                if(length < (i+1) || toCheck != str.charAt(i))
                    return sb.toString();
                count ++;
            }
            if (count == strs.length)
                sb.append(toCheck);
        }
        return sb.toString();
    }
}
