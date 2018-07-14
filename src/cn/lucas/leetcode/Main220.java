package cn.lucas.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Lucas Ma
 */
public class Main220 {


    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
     * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     *
     *
     *
     *
     */


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length <= 1)
            return false;

        if (k <= 0)
            return false;

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling((long) nums[i] - (long) t) != null &&
                    set.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println(new Main220().containsNearbyAlmostDuplicate(nums, k, t));

    }
}
