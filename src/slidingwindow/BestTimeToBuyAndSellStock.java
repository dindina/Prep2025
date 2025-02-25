package slidingwindow;

/*
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Example 1:

Input: prices = [10,1,5,6,7,1]

Output: 6

 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices =  new int[]{10,1,5,6,7,1};

        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowPrice = prices[0];
        for(int i=1 ; i<prices.length;i++)
        {
            lowPrice= Math.min(prices[i],lowPrice);
            int profit = prices[i]-lowPrice;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
