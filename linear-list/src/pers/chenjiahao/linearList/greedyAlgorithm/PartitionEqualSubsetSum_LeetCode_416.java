package pers.chenjiahao.linearList.greedyAlgorithm;

import java.util.Arrays;

/**
 * 分割等和子集
 * [416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/)
 * @author ChenJiahao(五条)
 * @date 2024/11/05 19:37:18
 */
public class PartitionEqualSubsetSum_LeetCode_416 {

    public static boolean canPartition(int[] nums) {
        // 背包容量为S/2
        // 总和为奇数的话默认返回false
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0){
            return false;
        }

        // 能走到这里说明是偶数，本题要求的是两个相同子集，所以找和为S/2的组合
        int targetSubSum = sum / 2;

        if (nums.length == 2){
            return nums[0] == targetSubSum;
        }

        // 创建二维数组
        boolean[][] dp = new boolean[nums.length][targetSubSum + 1];

        // 第一行不需要跟上一行做交互，所以默认设置当前行值的列为true即可
        if (nums[0] <= targetSubSum){
            dp[0][nums[0]] = true;
        }

        // 初始化二维数组
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= targetSubSum; j++) {
                // 上一行值当前列的值
                boolean preLine = dp[i - 1][j];

                dp[i][j] = preLine;
                if (nums[i] == j) {
                    // 当前值等于长度 赋值为true
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j){
                    // 当前数小于时等于长度时
                    // 上一行当前列和当前行值的差值
                    boolean dValue = dp[i - 1][j - nums[i]];
                    // 上一行是true，默认继承，不算用了
                    dp[i][j] = preLine || dValue;
                }
            }
        }

        // 获取结果,最角落的值，代表是否有符合要求的组合
        return dp[nums.length - 1][targetSubSum];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        /*
        false true false false false false false false false false false false
        false true false false false true true false false false false false
        false true false false false true true false false false false true
        false true false false false true true false false false true true
         */

//        int[] nums = {1,2,3,5};
//        int[] nums = {1,2,3,4,5,6,7};
//        int[] nums = {1,5,3,6,3};
        System.out.println(canPartition(nums));
    }
}
