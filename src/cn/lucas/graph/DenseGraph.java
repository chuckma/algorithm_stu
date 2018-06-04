package cn.lucas.graph;

/**
 * @Author Lucas Ma
 * @Date 2018/6/4 下午9:25
 */
public class DenseGraph {

    private int n;//节点数
    private int m;//边
    private boolean directed;//是否有向图
    private boolean[][] g;//具体图数据

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0; // 初始化没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    /**
     * 节点个数
     *
     * @return
     */
    public int V() {
        return n;
    }

    /**
     * 边的个数
     *
     * @return
     */
    public int E() {
        return m;
    }


    /**
     * 向图中添加一个边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w))
            return;

        g[v][w] = true;
        if (!directed)
            g[w][v] = true;

        m++;
    }


    /**
     * 验证图中是否有从v到w的边
     *
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}

