package cn.lucas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lucas Ma
 */
public class Main447 {


    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
     * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * <p>
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [[0,0],[1,0],[2,0]]
     * <p>
     * 输出:
     * 2
     * <p>
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     */


    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>(); // 键存距离，值存距离出现的频率
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    // 和i不同的点
                    // 计算距离时不进行开根运算, 以保证精度
                    int dis = dis(points[i], points[j]);
                    if (map.containsKey(dis)) {
                        map.put(dis, map.get(dis) + 1);
                    } else {
                        map.put(dis, 1);
                    }
                }
            }
            for (Integer integer : map.values()) { //
                res += integer * (integer - 1);
            }
        }

        return res;
    }

    // 两坐标间距的平方
    private int dis(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0,}, {1, 0}, {2, 0}};

        System.out.println(new Main447().numberOfBoomerangs(a));
    }
}
