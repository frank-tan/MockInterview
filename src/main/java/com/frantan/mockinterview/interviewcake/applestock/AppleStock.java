package com.frantan.mockinterview.interviewcake.applestock;

public class AppleStock {
    /**
     * Suppose we could access yesterday's stock prices as an array, where:
     * The indices are the time in minutes past trade opening time, which was 9:30am local time.
     * The values are the price in dollars of Apple stock at that time.
     * So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.
     *
     * Write an efficient function that takes stockPricesYesterday and returns the best profit
     * I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
     *
     * No "shorting"—you must buy before you sell. You may not buy and sell in the same time step
     * (at least 1 minute must pass).
     *
     * The method implemented greedy algorithm. The best, average and worst case time complexity
     * are all O(n). The space complexity is O(1).
     */
    static public int getMaxProfit(int[] stockPricesYesterday) {
        if(stockPricesYesterday == null || stockPricesYesterday.length < 2){
            throw new IllegalArgumentException("At least 2 prices are required");
        }
        int lowestPrice = Integer.MAX_VALUE;
        int maxGain = Integer.MIN_VALUE;

        // Use greedy algorithm to find the max gain and lowest price for every new element
        for(int i = 0; i< stockPricesYesterday.length; i++) {
            int currentPrice = stockPricesYesterday[i];
            int maxGainAtCurrentPrice = currentPrice - lowestPrice;
            if(maxGainAtCurrentPrice > maxGain) {
                maxGain = maxGainAtCurrentPrice;
            }
            if(currentPrice < lowestPrice) {
                lowestPrice = currentPrice;
            }
        }
        return maxGain;
    }
}
