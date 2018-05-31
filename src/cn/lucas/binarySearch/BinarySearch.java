package cn.lucas.binarySearch;

/**
 * @Author Lucas Ma
 * @Date 2018/5/31 下午8:57
 * <p>
 * 二分查找法
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int find(Comparable[] arr, Comparable target) {

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                // target 在mid 的左半部分
                // arr[mid].compareTo(target) == 0 不符合，则需要除去mid mid-1
                r = mid - 1;
            } else {
                // target 在mid 的右半部分
                l = mid + 1;
            }
        }
        return -1;
    }


    // 测试非递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }
}
