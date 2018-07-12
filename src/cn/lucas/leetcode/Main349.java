package cn.lucas.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author Lucas Ma
 */
public class Main349 {

    /**
     * 给定两个数组，写一个函数来计算它们的交集。
     *
     * 例子:
     *
     *  给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
     *  [1,2][2,2]
     *
     * 提示:
     *
     * 每个在结果中的元素必定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet set = new TreeSet();
        // 先去重 num1 放入 set
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) { // num1 中包含 num2中的元素，则将其 add 进 list
                list.add(nums2[i]);
                set.remove(nums2[i]); //  移除已经判断过的元素
            }
        }

        int[] res = new int[list.size()]; // 返回 list.size 长度的的数组
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};

        int[] res = new Main349().intersection(num1, num2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }
}
