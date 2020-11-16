package com.oliver.leetcode.dp.palindrome;

import org.junit.jupiter.api.Test;

// 516
public class LongestPalindromicSubsequence {

    @Test
    void check() {
        String s = "cbbd";
        int output = longestPalindromeSubseq(s);
        System.out.println(output);
    }

    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqHelper(s, 0, s.length() - 1, 0);
    }

    private int longestPalindromeSubseqHelper(String s, int i, int j, int size) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return size;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return longestPalindromeSubseqHelper(s, i + 1, j - 1, size + 2);
        } else {
            return Math.max(longestPalindromeSubseqHelper(s, i + 1, j, size), longestPalindromeSubseqHelper(s, i, j - 1, size));
        }
    }

}
