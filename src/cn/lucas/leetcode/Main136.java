package cn.lucas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lucas Ma
 */
public class Main136 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     *
     *
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     *
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }


        for (Map.Entry<Integer, Integer> integer : map.entrySet()) {
            if (integer.getValue() == 1) {
                 int res = integer.getKey();
                 return res;
            }
        }
        throw new IllegalStateException("the input has no solution");
    }


    public static void main(String[] args) {
        int[] nums = { 2, 2, 1};
        System.out.println(new Main136().singleNumber(nums));
    }
}
