package com.oliver.leetcode.dp.palindrome;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// 516
public class LongestPalindromicSubsequence {

    @Test
    void check() {
        String s = "aaa";
        int output = longestPalindromeSubseq(s);
        System.out.println(output);
    }

    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqHelper(s, 0, s.length() - 1, new HashMap<>());
    }

    private int longestPalindromeSubseqHelper(String s, int i, int j, Map<String, Integer> memo) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        String key = i + "|" + j;

        if (!memo.containsKey(key)) {
            if (s.charAt(i) == s.charAt(j)) {
                memo.put(key, longestPalindromeSubseqHelper(s, i + 1, j - 1, memo) + 2);
            } else {
                memo.put(key, Math.max(longestPalindromeSubseqHelper(s, i + 1, j, memo), longestPalindromeSubseqHelper(s, i, j - 1, memo)));
            }
        }
        return memo.get(key);
    }

}
