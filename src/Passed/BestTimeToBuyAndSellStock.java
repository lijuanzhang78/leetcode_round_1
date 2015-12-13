package Passed;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE, diff = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min_price) min_price = prices[i];
            if(prices[i] - min_price > diff ) {
                diff = prices[i] - min_price;
            }
        }
        
        return diff;
        
        
    }

}
