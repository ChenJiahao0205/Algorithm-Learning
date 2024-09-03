package pers.chenjiahao.linearList.twoPointers;

import java.util.Arrays;

/**
 * 对撞指针
 * [167. 两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/)
 * @author ChenJiahao(五条)
 * @date 2024/09/03 20:54:42
 */
public class TwoPointersFromOppositeEnds_LeetCode_167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left != right){
            if (numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            }else if (numbers[left] + numbers[right] > target){
                // right向左移动
                right--;
            }else{
                // 能走到这里肯定是left + right < target
                // left向右移动
                left++;
            }
        }

        return null;
    }
}
