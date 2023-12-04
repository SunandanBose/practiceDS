
/**
 * BestTimeToBuyAndSellStock
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            if(prices[i] > lowest)
                maxProfit = Math.max(maxProfit, (prices[i] - lowest));
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;

    }
}