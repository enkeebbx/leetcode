package com.oliver.leetcode.dp.houserobber;

import org.junit.jupiter.api.Test;

//  198
public class HouseRobber {
    @Test
    void check() {
        int[] nums = {0};
        int output = rob(nums);
        System.out.println(output);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        if (nums.length >= 2) {
            max[1] = Math.max(nums[1], nums[0]);
        }
        if (nums.length >= 3) {
            for (int i=2; i<nums.length; i++) {
                max[i] = Math.max(max[i-1], nums[i] + max[i-2]);
            }
        }
        return max[nums.length-1];
    }
}
