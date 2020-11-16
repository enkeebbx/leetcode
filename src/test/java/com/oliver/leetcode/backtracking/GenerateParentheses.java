package com.oliver.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// 22
public class GenerateParentheses {

    @Test
    void check() {
        List<String> output = generateParenthesis(3);
        System.out.println(output);
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        generateParenthesisHelper(output, "", 0, 0, n);
        return output;
    }

    private void generateParenthesisHelper(List<String> combs, String comb, int numOpen, int numClose, int max) {
        if (comb.length() == max * 2) {
            combs.add(comb);
        } else {
            if (numOpen < max) {
                generateParenthesisHelper(combs, comb + "(", numOpen + 1, numClose, max);
            }
            if (numClose < numOpen) {
                generateParenthesisHelper(combs, comb + ")", numOpen , numClose + 1, max);
            }
        }
    }
}
