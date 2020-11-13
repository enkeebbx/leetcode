package com.oliver.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// 46
public class Permutations {

    @Test
    void check() {
        int[] nums = {0, 1, 2};
        List<List<Integer>> output = permute(nums);
        System.out.println(output);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        permuteHelper(perms, new ArrayList<>(), nums);
        return perms;
    }

    private void permuteHelper(List<List<Integer>> perms, List<Integer> perm, int[] nums) {
        if (perm.size() == nums.length) {
            perms.add(new ArrayList<>(perm));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if (perm.contains(nums[i])) {
                    continue;
                }
                perm.add(nums[i]);
                permuteHelper(perms, perm, nums);
                perm.remove(perm.size() - 1);
            }
        }
    }

}
