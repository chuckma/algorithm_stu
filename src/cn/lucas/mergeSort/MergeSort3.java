package cn.lucas.mergeSort;

/**
 * @Author Lucas Ma
 * @Date 2018/5/27 下午5:57
 *
 * [2,8,6,5,7] [4,3,1,10,9]
 */
public class MergeSort3 {

    private MergeSort3(){}

    public static void sort(Comparable[] arr,int n) {
        sort(arr,0,n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        } else {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
    }

}
