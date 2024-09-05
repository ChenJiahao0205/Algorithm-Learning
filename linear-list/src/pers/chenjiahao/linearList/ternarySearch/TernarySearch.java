package pers.chenjiahao.linearList.ternarySearch;

/**
 * 三分枚举(三分法)
 * 求单峰数组的最大值
 * @author ChenJiahao(五条)
 * @date 2024/09/05 23:36:54
 */
public class TernarySearch {
    /*
        题目描述：
        给定一个长度为 nnn 的数组 `nums`，其中该数组是一个**单峰数组**，即数组在某一处峰值之前是递增的，而峰值之后是递减的。请你设计一个算法，找到这个数组中的**最大值**。
        你需要使用 **三分枚举法** 来寻找该峰值。要求算法的时间复杂度为 O(log⁡n)O(\log n)O(logn)。

        #### 示例 1：
        plaintext复制代码输入: nums = [1, 3, 8, 12, 4, 2]
        输出: 12

        #### 示例 2：
        plaintext复制代码输入: nums = [10, 9, 8, 7, 6, 5]
        输出: 10

        #### 示例 3：

        plaintext复制代码输入: nums = [1, 2, 3, 5, 6, 4, 3, 2]
        输出: 6

        #### 约束条件：

        - 数组 `nums` 长度为 nnn，满足 3≤n≤1053 \leq n \leq 10^53≤n≤105。
        - 数组中元素 `nums[i]` 满足 −109≤nums[i]≤109-10^9 \leq nums[i] \leq 10^9−109≤nums[i]≤109。
        - 数组是单峰数组，即存在一个位置 `i` 使得 `nums[0] < nums[1] < ... < nums[i] > nums[i+1] > ... > nums[n-1]`。
    */

    public static void main(String[] args) {
        System.out.println(ternarySearch(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(ternarySearch(new int[]{10, 9, 8, 7, 6, 5}));
        System.out.println(ternarySearch(new int[]{1, 2, 3, 5, 6, 4, 3, 2}));
    }

    public static int ternarySearch(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (nums[mid1] < nums[mid2]){
                // 最大值在右侧，移动左边界
                left = mid1 + 1;
            }else if (nums[mid1] > nums[mid2]){
                // nums[mid1] >= nums[mid2]
                // 最大值在左侧
                right = mid2 - 1;
            }else {
                // 最大值可能在mid2处
                right = mid2;
            }
        }

        return nums[left];
    }

}
