package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。
     * 如果不存在符合条件的子数组，返回 0。
     *
     *
     * 示例
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的子数组
     *
     */

    /**
     * 滑动窗口 解法
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Argument");
        }
        // nums[l...r] 闭合区间是一个子数组，设置 r 为 -1 是让起初子数组不包含任何元素。
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1; // 最小子数组的长度，当然了子数组的长度是不肯能大于 nums.length 的。
        while (l < nums.length) { // l 还能取值
            if (sum < s && r + 1 < nums.length) { // sum 小于目标值 s r+1 一定要小于 nums.length
                // 右边界r 向右滑动一个， 即 r++ ,并将num[r]加在 sum 里
                sum += nums[++r];
            } else {
                // 右边界到头了，即r 不能再加1 滑动了 或者 sum >= s 的情况，
                // 这就需要将 sum 减去nums[l]  ，并将 左边界 l 向右滑动一个了 即 l++
                sum -= nums[l++];
            }

            if (sum >= s) {
                // 取最小值，r-l+1 是获得的子数组的长度
                res = Math.min(res, r - l +1);
            }
        }


        if (res == nums.length + 1) {
            // res 值没做更新 ，也就是没找到 sum >=s 的子数组 ，按照题设 返回 0
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Main209().minSubArrayLen(s,nums));
    }
}
