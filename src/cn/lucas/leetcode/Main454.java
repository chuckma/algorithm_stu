package cn.lucas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lucas Ma
 */
public class Main454 {



    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
     * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 例如:
     *
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */


    /**
     * 该题目如果使用暴力解法，四层for 循环的话，时间复杂度就是 O(n^4) 了 长度如果是 500 的话 500^4 是很大的
     * 选择让其中两个数组求和加入map，通过搜索表的方式来解决 。这种情况下只有 2 个for 循环，500^2 250000
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {

                int sum = C[i] + D[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1); // 存在就将频率加 1
                } else {
                    map.put(sum, 1); // 不存在就加入map
                }

            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(-sum)) {
                    // 如果 map 里面包含-sum 说明有这样的四个元素之和 为 0 ，对应 value 就是所求元组
                    res += map.get(-sum);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-1, -2};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(new Main454().fourSumCount(a, b, c, d));
    }
}
