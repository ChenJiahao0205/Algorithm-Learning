package pers.chenjiahao.linearList.twoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 * 滑动窗口
 * [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)
 * @author ChenJiahao(五条)
 * @date 2024/09/04 23:02:37
 */
public class OptimizedSlidingWindow_LeetCode_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("acbbaca", "aba"));
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public static String minWindow(String s, String t) {
        // 存储目标集合中字符个数Map
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // 左窗口
        int left = 0;
        // 右窗口
        int right = 0;
        // 当前窗口内匹配的所需字符种类数
        int matchCount = 0;
        // 目标字符种类数
        int requiredMatches = targetMap.size();
        // 最小长度
        int minLength = Integer.MAX_VALUE;
        // 最小子串的起始位置
        int minBeginIndex = 0;

        // 窗口中包含的字符个数
        Map<Character, Integer> windowMap = new HashMap<>();

        // 循环条件，没有越界
        while (right < s.length()){
            char c = s.charAt(right);
            // 目标map中包含当前右侧值
            if (targetMap.containsKey(c)){
                // 放入窗口Map中
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                // 如果字符出现的次数一致，表示有一个字符的出现次数相同
                if (windowMap.get(c).equals(targetMap.get(c))){
                    // 命中数+1
                    matchCount++;
                }

            }

            // 右窗口移动
            right++;

            // 如果目标字符种类数 等于 当前窗口内匹配的所需字符种类数,左窗口移动
            while (matchCount == requiredMatches){
                // 找到了符合条件的数据
                // 右窗口 - 左窗口 小于当前最小长度
                if (right - left < minLength){
                    // 重新赋值最小长度
                    minLength = right - left;
                    // 重新赋值最小长度开始位置
                    minBeginIndex = left;
                }

                char c1 = s.charAt(left);
                // 目标map中包含当前左侧值
                if (targetMap.containsKey(c1)){
                    // 窗口map中命中数-1
                    // 放入窗口Map中
                    windowMap.put(c1, windowMap.get(c1) - 1);
                    // 窗口map中字符出现的次数 少于 目标map中这个字符出现的次数了，说明当前这个字符不命中目标map中的该字符了
                    // 例如：s为aaabc  t为abc  当window中的a减少了1，s中的a还是有两个 大于 t中的一个a，还是满足包含条件的
                    if (windowMap.get(c1) < targetMap.get(c1)) {
                        // 命中数-1
                        matchCount--;
                    }

                }

                left++;
            }
        }


        return minLength == Integer.MAX_VALUE ? "" : s.substring(minBeginIndex, minBeginIndex + minLength);
    }
}
