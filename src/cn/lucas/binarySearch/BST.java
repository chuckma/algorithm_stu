package cn.lucas.binarySearch;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 是否包含 key 的节点
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    private boolean contain(Node node, Key key) {

        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }


    public Value search(Key key) {
        return search(root, key);
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 最小键值
     * @return
     */
    public Key minimum() {
        if (count == 0) {
            throw new IllegalArgumentException("BST is empty");
        } else {
            Node node = minimum(root);
            return node.key;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }


    /**
     * 最大键值
     * @return
     */
    public Key maxmum() {
        if (count == 0) {
            throw new IllegalArgumentException("BST is empty");
        } else {
            Node node = maxmum(root);
            return node.key;
        }
    }

    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maxmum(node.right);
        }
    }

    /**
     * 删除最小值
     */
    public void removeMin() {
        if (root!=null) {
            root=removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;

    }

    /**
     * 删除最大值
     */
    public void removeMax() {
        if (root != null) {

        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left=null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }



    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer, String> bst = new BST<Integer, String>();
        for (int i = 0; i < N; i++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if (i < N)
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }


        String name = "abner chai";
        //String name = null;
        assert (name!=null):"变量name为空null";
        System.out.println(name);

    }

}
