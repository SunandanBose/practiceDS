
/**
 * Day25
 */
public class Day25 {

    public static void main(String[] args) {
        Day25 day25 = new Day25();
        int numOfWays = day25.climbStairs(8);
        System.out.println(numOfWays);
    }

    private int climbStairs(int n) {
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        if (n < 2)
            return mem[n - 1];
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }

}