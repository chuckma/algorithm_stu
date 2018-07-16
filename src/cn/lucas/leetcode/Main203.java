package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main203 {

    /**
     *
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */



    public ListNode removeElements(ListNode head, int val) {

        // 虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;

    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Main203()).removeElements(head, val);
        System.out.println(head);
    }
}
