/**
 * LengthOfLastWord
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        char[] ch = s.toCharArray();
        int count = 0;
        for(int i = ch.length - 1; i >= 0; i--) {
            if(ch[i] == ' ')
                return count;
            count ++;
        }
        return count;
    }
}