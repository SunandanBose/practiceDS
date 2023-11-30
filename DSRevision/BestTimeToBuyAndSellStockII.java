
/**
 * BestTimeToBuyAndSellStock
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1])
                profit +=  prices[i + 1] - prices[i];
        }
        return profit;
    }
}