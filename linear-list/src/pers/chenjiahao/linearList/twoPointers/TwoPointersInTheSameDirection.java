package pers.chenjiahao.linearList.twoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 相同方向的双指针
 * [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)
 * @author ChenJiahao(五条)
 * @date 2024/09/03 20:55:41
 */
public class TwoPointersInTheSameDirection {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        // 已经出现过的元素map
        Map<Integer, Integer> currentElementMap = new HashMap<>();
        // 遍历数组
        int left = 0;
        // 需要判断的右边界
        int right = nums.length - 1;
        // 记录不重复元素的结束位置
        int noRepeatEndIndex = 0;

        while (left <= right){
            int num = nums[left];
            // 判断当前元素是否存在于map中
            if (currentElementMap.getOrDefault(num, 0) == 0){
                // 当前map中不包含当前元素
                // 将当前元素放入map中
                currentElementMap.put(num, 1);
                // 修改不重复元素的结束位置
                noRepeatEndIndex = left;
                // 继续遍历数组
                left++;
                continue;
            }

            // 当前元素与前面元素重复
            // 将当前元素放到right位，其余元素全部前移
            swapNums(nums, left, right);
            // 当前right位存放了重复元素
            right--;
        }

        return noRepeatEndIndex + 1;
    }

    /**
     * 将待删除的元素放到最后
     */
    private static void swapNums(int[] nums, int left, int right) {
        // 保存 left 位置的元素
        int temp = nums[left];

        // 从 left 到 right 的元素向前移动一位
        for (int i = left; i < right; i++) {
            nums[i] = nums[i + 1];
        }

        // 将保存的元素放到 right 位置
        nums[right] = temp;
    }
}
