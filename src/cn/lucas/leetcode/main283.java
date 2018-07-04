package cn.lucas.leetcode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lucas Ma
 *
 *
 */
public class main283 {

    /*
    * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    * 输入: [0,1,0,3,12]  输出: [1,3,12,0,0]
    * 必须在原数组上操作，不能拷贝额外的数组。
     *
    */

    public static void moveZeroes(int[] nums) {

        List<Integer> list = new ArrayList<>();
        // 先将不为 0 的元素放置在一个 list里。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        // 将 list 里的元素放回原数组
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        // 在原数组余下的位置（也就是最后发的位置）放置 0 ，这样就将 0 移动到数组末尾了。
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String args[]) throws NoSuchMethodException {

        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
