package cn.lucas.mergeSort;

import java.util.Arrays;

/**
 * @Author lucasma
 * @Date 2018/5/27 下午2:00
 * <p>
 * 归并排序 left :[2,3,6,8] right : [1,4,5,7]
 */
public class MergeSort {

    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {
        // 第一次调用递归函数标记为 1 次，每一次递归调用都是从一个新的开始，第 2 次里新调用的递归函数标记为 2，
        // 1 等得 2 的返回结果，2 里调用的标记为 3 ，2等得3 的返回结果，以此循环调用，直到触发递归结束条件。
        if (l >= r) {
            return;
        } else {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 2000000);
        Integer[] arr1 = {3, 2, 8, 6, 1, 4, 5, 7};

        long startTime = System.currentTimeMillis();
        Arrays.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        SortTestHelper.testSort("cn.lucas.mergeSort.MergeSort", arr1);
        return;
    }
}
