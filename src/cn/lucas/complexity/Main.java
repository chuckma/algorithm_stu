package cn.lucas.complexity;

/**
 * @Author Lucas Ma
 * 复杂度分析
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 如果想在 1s 内解决问题
         * O(n^2) 的算法可以的处理 10^4 级别的数据
         * O(n) 的算法可以处理 10^8 级别的数据
         * O(nlogn) 的算法可以处理 10^7 级别的数据
         */

        // 数据规模每次增大10倍进行测试
        for (int x = 1; x <= 9; x++) {

            int n = (int) Math.pow(10, x);

            long startTime = System.currentTimeMillis();

            long sum = 0;
            for (int i = 0; i < n; i++)
                sum += i;

            long endTime = System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }
}
