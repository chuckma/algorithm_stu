package cn.lucas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lucas Ma
 */
public class Main257 {

    /**
     *
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     */


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return null;
        }

        // 如果root 节点的左子树和右子树都为空，说明路劲到此为止
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        // 递归遍历左子树
        List<String> leftPath = binaryTreePaths(root.left);
        for (String s : leftPath) {
            StringBuffer sb = new StringBuffer(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }


        // 递归遍历右子树
        List<String> rightPath = binaryTreePaths(root.right);
        for (String s : rightPath) {
            StringBuffer sb = new StringBuffer(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }

}
