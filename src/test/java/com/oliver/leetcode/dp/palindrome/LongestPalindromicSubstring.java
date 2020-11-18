package com.oliver.leetcode.dp.palindrome;

import org.junit.jupiter.api.Test;

// 5
public class LongestPalindromicSubstring {

    @Test
    void check() {
        String s = "ac";
        String output = longestPalindrome(s);
        System.out.println(output);
    }

    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] isPalindromeTable = init(s);
        if (N == 1) {
            return s.substring(0, 1);
        }
        int palindromeStartPos = 0, maxLength = 1;
        for (int len=2; len<=N; len++) {
            for (int i=0; i<=N-len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (isPalindromeTable[i+1][j-1] || len == 2)) {
                    isPalindromeTable[i][j] = true;
                    if (len > maxLength) {
                        palindromeStartPos = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(palindromeStartPos, palindromeStartPos + maxLength);
    }

    private boolean[][] init(String s) {
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                isPalindrome[i][j] = false;
            }
        }
        for (int i=0; i<N; i++) {
            isPalindrome[i][i] = true;
        }
        return isPalindrome;
    }

}
