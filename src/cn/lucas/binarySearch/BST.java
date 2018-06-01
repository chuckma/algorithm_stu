package cn.lucas.binarySearch;

/**
 * @Author Lucas Ma
 * @Date 2018/6/1 下午9:29
 * <p>
 * 二分搜索树
 */
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }


    private Node root;// 根节点
    private int count;// 节点个数

    /**
     * 一颗空的二分搜索树
     */
    public BST() {
        root = null;
        count = 0;
    }

    /**
     * 返回 二分搜索树的节点数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断二分搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 二分搜索树插入元素
     *
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 向以 node 为节点的二分搜索树中，插入节点数据（key，value）
     * 返回插入新节点后二分搜索树的 根 root
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, Key key, Value value) {
        // 递归到底的情况
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            // key 是否就等于 node 的 key
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            // 如果 key 比 node 的key 小，就在 node 的左子树插入
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

}
