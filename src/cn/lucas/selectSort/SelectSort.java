package cn.lucas.selectSort;


/**
 * @Author lucasma
 * @Date 2018/5/27 上午9:37
 * <p>
 * <p>
 * 选择排序
 */
public class SelectSort {

    private SelectSort(){}
    public static void selectSorSTB(int[] arr) {

        // 寻找 [i,n) 区间里的最小值
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(i, minIndex, arr);
        }
    }

    public static void selectSorBTS(int[] arr) {

        // 寻找 [i,n) 区间里的最小值
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            swap(i, maxIndex, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectSort.selectSorSTB(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SelectSort.selectSorBTS(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
