package pers.chenjiahao.linearList.discretization;

import java.util.*;

/**
 * 离散化
 * [315. 计算右侧小于当前元素的个数](https://leetcode.cn/problems/count-of-smaller-numbers-after-self/)
 * @author ChenJiahao(五条)
 * @date 2024/09/07 21:59:20
 */
public class Discretization_Leetcode_315 {

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 1, 6, 1, 3, 2}));
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }

    public static List<Integer> countSmaller(int[] nums) {
        // key为数值，value为该值所处的所有索引位置
        Map<Integer, TreeSet<Integer>> numValueAndAllIndexSetMap = new HashMap<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            TreeSet<Integer> allNumIndexTreeSet = numValueAndAllIndexSetMap.getOrDefault(num, new TreeSet<>());
            allNumIndexTreeSet.add(i);
            numValueAndAllIndexSetMap.put(num, allNumIndexTreeSet);
        }

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int count = 0;

            for (Map.Entry<Integer, TreeSet<Integer>> integerTreeSetEntry : numValueAndAllIndexSetMap.entrySet()) {
                // 如果当前值大于map中当前迭代的这个值
                if (currentNum > integerTreeSetEntry.getKey()){
                    TreeSet<Integer> allNumIndexTreeSet = integerTreeSetEntry.getValue();
                    // 获取所有大于当前索引i的索引数
                    count += allNumIndexTreeSet.tailSet(i).size();
                }
            }

            counts.add(count);
        }

        return counts;
    }
}
