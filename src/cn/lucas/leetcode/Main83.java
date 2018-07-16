package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main83 {

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head=head.next;
            }
        }

        return cur;
    }
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3, 3};

        ListNode head = new ListNode(arr);
        System.out.println(new Main83().deleteDuplicates(head));
    }
}
