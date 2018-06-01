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


}
