package cn.lucas.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Lucas Ma
 */
public class Main217 {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * 示例 1
     *
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 示例 2
     *
     * 输入: [1,2,3,4]
     * 输出: false
     */



    public static boolean containsDuplicate(int[] nums) {
        boolean b = false;
        Set set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() < nums.length) {
            b = true;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] arr1 ={1,2,3,1};
        int[] arr2 ={1,2,3,4};
        System.out.println(containsDuplicate(arr1));
        System.out.println(containsDuplicate(arr2));
    }
}
