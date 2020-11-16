package com.oliver.leetcode.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CoinChange2 {
    @Test
    void check() {
        int amount = 10;
        int[] coins = {10};
        int output = change(amount, coins);
        System.out.println(output);
    }

    public int change(int amount, int[] coins) {
        List<List<Integer>> combs = new ArrayList<>();
        changeHelper(combs, new ArrayList<>(), coins, amount, 0);
        return combs.size();
    }

    private void changeHelper(List<List<Integer>> combs, List<Integer> comb, int[] coins, int amount, int prevIndex) {
        int sum = comb.stream().mapToInt(Integer::intValue).sum();
        if (sum > amount) {
            return;
        } else if (sum == amount) {
            combs.add(new ArrayList<>(comb));
        } else {
            for (int i = 0; i < coins.length; i++) {
                if (prevIndex > i) {
                    continue;
                }
                comb.add(coins[i]);
                changeHelper(combs, comb, coins, amount, i);
                comb.remove(comb.size()-1);
            }
        }
    }

}
