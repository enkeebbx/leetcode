package com.oliver.leetcode.dp.houserobber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

// 213
public class HouseRobber2 {
    @Test
    void check() {
        int[] nums = {2,3,2};
        int output = rob(nums);
        System.out.println(output);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return Math.max(robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    robHelper(Arrays.copyOfRange(nums, 1, nums.length)));
        }
    }

    private int robHelper(int[] nums) {
        if (nums.length == 0) return 0;
        int[] max = new int[nums.length+1];
        max[0] = 0;
        max[1] = nums[0];
        for (int i=1; i<nums.length; i++) {
            max[i+1] = Math.max(max[i], max[i-1] + nums[i]);
        }
        return max[nums.length];
    }

}
