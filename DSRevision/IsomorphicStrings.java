public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        for(int i = 0; i < s.length(); i++) {
            int leftAscCode = (int)s.charAt(i);
            int rightAscCode = (int)t.charAt(i);

            if(sFreq[leftAscCode] != tFreq[rightAscCode]) 
                return false;

            sFreq[leftAscCode] = i + 1;
            tFreq[rightAscCode] = i + 1;
        }
        return true;
    }
}