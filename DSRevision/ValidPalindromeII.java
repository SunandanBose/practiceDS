public class ValidPalindromeII {
    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("cbbcc"));
        System.out.println(validPalindromeII.validPalindrome("bebeb"));
        System.out.println(validPalindromeII.validPalindrome("abca"));
    }

    public boolean validPalindrome(String s) {
        int totalLength = s.length();
        if(isPalindrome(s))
            return true;
        for(int i = 0; i < totalLength; i++){
            if(s.charAt(i) == s.charAt(totalLength - 1 - i))
                continue;
            // on removing i th character
            String temp1 = s.substring(0,i) + s.substring(i+1);
            // on removing (totalLength - 1 - i) th character
            String temp2 = s.substring(0,totalLength - 1 - i) + s.substring(totalLength - 1 - i+1);
            if(isPalindrome(temp1) || isPalindrome(temp2))
                return true;
            return false;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        if(s.equals(reverseString(s)))
            return true;
        return false;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
