package com.oliver.leetcode.dp;

import org.junit.jupiter.api.Test;

// 53
public class MaximumSubarray {
    @Test
    void check() {
        int[] nums = {-1};
        int output = maxSubArray(nums);
        System.out.println(output);
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
