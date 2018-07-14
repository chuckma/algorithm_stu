package cn.lucas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lucas Ma
 */
public class Main1 {

    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     *
     */


    /**
     * 两次循环，暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int resSub = target - nums[i]; // 目标值减去数组元素，作为下一个循环的比较对象
            for (int j = i + 1; j < nums.length; j++) {
                if (resSub == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    /**
     * 搜索表的方式来查找
     */

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] res = {i, map.get(complement)};
                return res;
            }

            map.put(nums[i], i);
        }
        throw new IllegalStateException("the input has no solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int t = 9;
//        int[] res = new Main1().twoSum(nums, t);
        int[] res = new Main1().twoSum1(nums, t);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
