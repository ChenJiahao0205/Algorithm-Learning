package pers.chenjiahao.linearList.twoPointers;

/**
 * 对撞指针
 * [125. 验证回文串](https://leetcode.cn/problems/valid-palindrome/)
 * @author ChenJiahao(五条)
 * @date 2024/09/03 21:09:45
 */
public class TwoPointersFromOppositeEnds_LeetCode_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("ra"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        // 移除所有非字母数字字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        int length = sb.length();

        // 处理特殊情况" "
        if (length == 0){
            return true;
        }

        if (length == 1){
            return true;
        }

        if (length == 2){
            return sb.charAt(0) == sb.charAt(1);
        }

        int left = length / 2 - 1;
        int right;

        //  1 2 3 4
        // 1 2 3 4 5
        // 初始化右指针，奇数和偶数情况不同
        if (length % 2 == 0){
            // 偶数
            right = length / 2;
        }else {
            // 奇数
            right = length / 2 + 1;
        }

        while (left >= 0 && right <= length - 1){
            if (sb.charAt(left) != sb.charAt(right)){
                return false;
            }

            left--;
            right++;
        }

        return true;
    }
}
