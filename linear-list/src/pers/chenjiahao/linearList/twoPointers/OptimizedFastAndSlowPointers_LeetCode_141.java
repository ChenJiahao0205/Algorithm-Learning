package pers.chenjiahao.linearList.twoPointers;

/**
 * 算法优化
 * 快慢指针
 * [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/)
 * @author ChenJiahao(五条)
 * @date 2024/09/05 22:35:31
 */
public class OptimizedFastAndSlowPointers_LeetCode_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        System.out.println(hasCycle(head));

        node4.next = head;
        System.out.println(hasCycle(head));

        ListNode head2 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);

        node7.next = node5;
        node6.next = node7;
        node5.next = node6;
        head2.next = node5;
        System.out.println(hasCycle(head2));

    }

    /**
     * 偶数个结点
     *  1   2   3   4
     *  A   B
     *      A       B
     *      B   A
     *             AB
     *
     * --------------------------
     * 奇数个结点
     * --------------------------
     *  1   2   3   4   5
     *  A   B
     *      A       B
     *  B       A
     *          B   A
     *                 AB
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        // 一次移动一步
        ListNode oneStepNode = head;
        // 一次移动两步
        ListNode twoStepNode = head.next;

        // 只要结点不同就一直循环寻找
        while (oneStepNode != twoStepNode){
            if (twoStepNode == null || twoStepNode.next == null){
                // 超出了最长的链表
                return false;
            }

            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
        }

        // 找到了环
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

