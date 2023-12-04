import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<String, Integer> cache  = new HashMap();
    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("10"));//1
        System.out.println(decodeWays.numDecodings("27"));//1
        System.out.println(decodeWays.numDecodings("26"));//2
        System.out.println(decodeWays.numDecodings("11106"));//2
        System.out.println(decodeWays.numDecodings("111111111111111111111111111111111111111111111"));//1836311903
    }

    public int numDecodings(String s) {
        if(s == null || s.equals("") || s.charAt(0) == '0')
        	return 0;
        if(cache.get(s) != null)
            return cache.get(s);
        if(s.length() <= 2 && parseInteger(s) <= 26){
            if(parseInteger(s) % 10 == 0)
                return 1;
            return s.length();
        }
        int result = numDecodings(s.substring(1));
        if(s.length() > 1 && parseInteger(s.substring(0,2)) <= 26)
        	result += numDecodings(s.substring(2));
        if(cache.get(s) == null)
            cache.put(s, result);
        return result;
    }

    private Integer parseInteger(String s){
        return Integer.parseInt(s);
    }
}
