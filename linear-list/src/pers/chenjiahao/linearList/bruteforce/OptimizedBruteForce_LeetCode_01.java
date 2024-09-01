package pers.chenjiahao.linearList.bruteforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * 线性枚举(穷举法、暴力法)
 * [1. 两数之和](https://leetcode.cn/problems/two-sum/)
 * @author ChenJiahao(五条)
 * @date 2024/09/01 14:01:27
 */
public class OptimizedBruteForce_LeetCode_01 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Map的key存储每个下标对应的值，value存储下标
        Map<Integer, Integer> valueAndIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (valueAndIndexMap.containsKey(target - nums[i])){
                return new int[]{valueAndIndexMap.get(target - nums[i]), i};
            }

            valueAndIndexMap.put(nums[i] , i);
        }

        return null;
    }
}
