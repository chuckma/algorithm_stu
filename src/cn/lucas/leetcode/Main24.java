package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main24 {

    /**
     *
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;

        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next=node1;
            node1.next=next;
            pre.next=node2;

            pre = node1; // 将 pre 移动到下一对需要交换的节点的前一个节点
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode node = new ListNode(arr);
        System.out.println(node);
        System.out.println(new Main24().swapPairs(node));
    }
}
