package pers.chenjiahao.linearList.twoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 滑动窗口
 * [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)
 * @author ChenJiahao(五条)
 * @date 2024/09/03 20:55:17
 */
public class SlidingWindow_LeetCode_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("acbbaca", "aba"));
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String retMinValue = "";

        while (left <= s.length() && right <= s.length()){
            String subString = s.substring(left, right);
            // 判断子串中是否包含各个目标字符串中的字符
            if (checkContainsAllTargetChar(subString, t)){
                // 找到了子串
                left++;
                // == 0是初始化时的赋值，确保第一个最小字符串可以赋给返回值
                if (retMinValue.length() == 0 || subString.length() < retMinValue.length()) {
                    retMinValue = subString;
                }
            }else{
                // 没找到，继续向右扩大范围
                right++;
            }

        }

        return retMinValue;

    }

    /**
     * 判断是否包含所有目标字符串中的字符
     */
    private static boolean checkContainsAllTargetChar(String subString, String t) {
        if (subString.length() < t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < subString.length(); i++) {
            char c = subString.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character targetChar = t.charAt(i);
            Integer charCount = map.get(targetChar);
            if (Objects.isNull(charCount) || charCount <= 0){
                // 不包含
                return false;
            }

            map.put(targetChar, --charCount);
        }

        return true;
    }
}
