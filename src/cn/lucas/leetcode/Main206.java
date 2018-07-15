package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
public class Main206 {

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre; // 反转
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

    }

}
