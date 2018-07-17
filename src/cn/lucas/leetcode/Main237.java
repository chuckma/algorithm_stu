package cn.lucas.leetcode;

import cn.lucas.Main;

/**
 * @Author Lucas Ma
 */
public class Main237 {

    /**
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *     4 -> 5 -> 1 -> 9
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     *
     *
     */


    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node=null;
            return;
        }
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;

        return;

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9};
        ListNode node = new ListNode(arr);
        new Main237().deleteNode(node);
    }
}
