package pers.chenjiahao.linearList.bruteforce;

import java.util.Arrays;

/**
 * 线性枚举(穷举法、暴力法)
 * [1. 两数之和](https://leetcode.cn/problems/two-sum/)
 * @author ChenJiahao(五条)
 * @date 2024/09/01 13:42:19
 */
public class BruteForce {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]){
                    return new int[]{i , j};
                }

            }
        }

        return null;
    }
}
