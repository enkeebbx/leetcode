package com.oliver.leetcode.dp;

import org.junit.jupiter.api.Test;

// 121
public class BestTimeToBuyAndSellStock {

    @Test
    void check() {
        int[] prices = {};
        int output = maxProfit(prices);
        System.out.println(output);
    }

    public int maxProfit(int[] prices) {
        int output = maxProfitHelper(prices, 0, 0);
        return Math.max(output, 0);
    }

    private int maxProfitHelper(int[] prices, int k, int max) {
        if (prices.length == 0) {
            return 0;
        }
        if (k == prices.length - 1) {
            return max;
        }
        int currentMax = max;
        for (int i=k+1; i<prices.length; i++) {
            currentMax = Math.max(currentMax, prices[i] - prices[k]);
        }
        return maxProfitHelper(prices, k+1, currentMax);
    }

}
