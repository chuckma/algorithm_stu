package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main19 {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     */


    /**
     * 解题思路：
     *  #->1->2->3->4->5->null  # 表示虚拟头节点
     *  要删除倒数 第 n 个节点 ，这里示例给出 n = 2，总共 5个节点，要删除4 这个节点， 说明节点倒数是从 1 开始的
     *  链表要删除节点，就要找到待删除节点的前一个节点，这里的前一个节点是 3 ,我们用叹号来标注这个节点
     *
     *           p          q
     *           ！         ！
     *  #->1->2->3->4->5->null
     *
     *  要删除 4 这个节点，就要找到 3 这个节点， 把最后的元素 我们让它标注为q 指向 null，
     *  可以看到 p 和 q 这两个索引直接的距离是固定的 n = 2,现在我们明确了 p 和 q 直接的长度是固定的 n
     *  所以将 p 和 q 同时向前移动，指导 p 移动到虚拟头节点，如下指示：
     *  p        q
     *  ！       ！
     *  #->1->2->3->4->5->null
     *
     *  由于 p 和 q 之间的长度是已知的 n ，所以就可以知道 当 p 是虚拟头节点的时候，q是哪个节点，p 向后移动 n + 1次就是q 的节点
     *
     *  接下来将 p 和 q 同时向右移动，直到q 这个元素指向 null 这个元素，就找到了要删除的元素的前一个元素
     *  p        q
     *  ！       ！
     *  #->1->2->3->4->5->null
     *     p        q
     *     ！       ！
     *  #->1->2->3->4->5->null
     *        p        q
     *        ！       ！
     *  #->1->2->3->4->5->null
     *           p         q
     *           ！        ！
     *  #->1->2->3->4->5->null
     *
     *
     *  这个解题思路只遍历了一遍链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 设置两个指针， 在初始的时候都指向 虚拟节点
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        // 将 q 向后移动 n+1 次
        for (int i = 0; i < n + 1; i++) {
            assert q != null;
            q = q.next;
        }
        while (q != null) {

            p = p.next;
            q = q.next;
        }
        // 删除这个节点
        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Main19()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
