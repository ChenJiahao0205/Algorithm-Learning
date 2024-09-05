package pers.chenjiahao.linearList.binarysearch;

/**
 * 二分枚举(二分法)
 * [704. 二分查找](https://leetcode.cn/problems/binary-search/)
 * @author ChenJiahao(五条)
 * @date 2024/09/05 22:52:10
 */
public class BinarySearch_Leetcode_704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                // nums[mid] == target
                return mid;
            }
        }

        return -1;
    }
}
