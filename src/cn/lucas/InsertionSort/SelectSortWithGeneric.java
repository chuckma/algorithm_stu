package cn.lucas.InsertionSort;


import cn.lucas.selectSort.Student;

/**
 * @Author lucasma
 * @Date 2018/5/27 上午9:37
 * <p>
 * <p>
 * 选择排序 模板编程
 */
public class SelectSortWithGeneric {

    private SelectSortWithGeneric(){}

    public static void sort(Comparable[] arr) {

        // 寻找 [i,n) 区间里的最小值
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(i, minIndex, arr);
        }
    }

    private static void swap(int i, int j, Object[] arr) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();



        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        sort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        sort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        sort(d);
        for( int i = 0 ; i < d.length ; i ++ )
            System.out.println(d[i]);
    }
}
