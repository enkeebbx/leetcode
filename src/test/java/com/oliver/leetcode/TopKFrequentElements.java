package com.oliver.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//347
public class TopKFrequentElements {

    @Test
    void check() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] output = topKFrequent(nums, k);
        System.out.println(Arrays.toString(output));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;
        for (int num : nums) {
            int frequency = frequencies.getOrDefault(num, 0) + 1;
            frequencies.put(num, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        LinkedList<Integer>[] buckets = new LinkedList[maxFrequency + 1];
        for(int i=0; i<=maxFrequency; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int cnt = 0;
        for (int i = maxFrequency; i>=0; i--) {
            for (Integer element: buckets[i]) {
                if (cnt == k) {
                    return output;
                }
                output[cnt] = element;
                cnt++;
            }
        }
        return output;
    }

}
