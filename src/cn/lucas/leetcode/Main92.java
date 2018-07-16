package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
public class Main92 {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        return head;
    }


    public static void main(String[] args) {

    }

}
