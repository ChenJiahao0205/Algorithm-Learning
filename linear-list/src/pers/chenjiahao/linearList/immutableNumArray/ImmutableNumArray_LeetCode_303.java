package pers.chenjiahao.linearList.immutableNumArray;

/**
 * 前缀和
 * [303. 区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/)
 * @author ChenJiahao(五条)
 * @date 2024/09/01 14:40:43
 */
public class ImmutableNumArray_LeetCode_303 {

    int[] prefixSum;

    public ImmutableNumArray_LeetCode_303(int[] nums) {
        // 用后一位存储当前位的和，所以要+1
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // prefixSum中对应right位的和，应该是right + 1
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int sum = new ImmutableNumArray_LeetCode_303(nums)
                .sumRange(1, 5);
        System.out.println(sum);
    }
}