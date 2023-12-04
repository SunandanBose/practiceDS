public class ValidPalindrome {
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("race a car");
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        String str = sb.toString();
        if(str.equalsIgnoreCase(sb.reverse().toString()))
            return true;
        return false;
    }

}
