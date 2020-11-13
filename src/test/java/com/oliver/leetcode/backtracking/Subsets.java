package com.oliver.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 78
public class Subsets {

    @Test
    void check() {
        int[] nums = {0, 1, 2};
        List<List<Integer>> output = subsets(nums);
        System.out.println(output);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void subsetsHelper(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int k) {
        subsets.add(new ArrayList<>(subset));
        for (int i=k; i<nums.length; i++) {
            subset.add(nums[i]);
            subsetsHelper(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

}