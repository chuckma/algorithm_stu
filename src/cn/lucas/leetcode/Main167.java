package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main167 {
    /**
     *
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    /**
     * 暴力解法
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if(numbers[l] + numbers[r] == target){
                int[] res = {l+1, r+1};
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }

        }
        throw new IllegalStateException("The input has no solution");
    }

    private boolean isSorted(int[] numbers){
        for(int i = 1 ; i < numbers.length ; i ++)
            if(numbers[i] < numbers[i-1])
                return false;
        return true;
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        printArr((new Main167()).twoSum(nums, target));
    }
}
