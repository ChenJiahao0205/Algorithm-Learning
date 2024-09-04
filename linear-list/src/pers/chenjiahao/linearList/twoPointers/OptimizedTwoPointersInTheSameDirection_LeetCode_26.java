package pers.chenjiahao.linearList.twoPointers;

/**
 * 优化代码，满足题意即可
 * 相同方向的双指针
 * [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)
 * @author ChenJiahao(五条)
 * @date 2024/09/05 00:36:15
 */
public class OptimizedTwoPointersInTheSameDirection_LeetCode_26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // 指针 j 记录不重复元素的下一个存放位置
        int j = 1;

        // 遍历数组，从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素与前一个元素不同，则将其放在 j 位置，并移动 j 指针
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 返回数组中不重复元素的数量
        return j;
    }
}
