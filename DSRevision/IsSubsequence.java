public class IsSubsequence {
    

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int jStartIndex = 0;
        for(char sChar: sArray) {
            boolean isCharPresent = false;
            for(int j=jStartIndex; j < tArray.length; j++){
                if(tArray[j] == sChar) {
                    jStartIndex = j + 1;
                    isCharPresent = true;
                    break;
                }
            }
            if(!isCharPresent)
                return false;
        }
        return true;
    }


}
