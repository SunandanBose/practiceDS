public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n <= 2 )
            return n;

        int[] mem = new int[45];
        mem[0] = 1;
        mem[1] = 2;

        for(int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        return mem[n-1];
    }
}
