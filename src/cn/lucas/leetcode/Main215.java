package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 *
 * 未解决
 */
public class Main215 {


    public static void sort(int[] nums) {
        int l = nums.length;
        sort(nums, 0, l - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        // 随机标定一个点
        swap(nums, l, (int) Math.random() * (r - l + 1) + l);

        int v = nums[l];
        int lt = l; // nums[l+1...lt] 之间的元素是小于 v 的
        int gt = r+1;// nums[gt...r]>v
        int i = l+1; // nums[lt+1...i] = v
        while (i < gt) {
            if (nums[i] < v) {
                swap(nums, i, lt + 1);
                i++; // i 后移
                lt++; // lt 后移
            } else if (nums[i] > v) {
                // 交换当前 i 和 gt 前一位
                swap(nums, i, gt - 1);
                gt--;
            } else { // nums[i]==v
                i++;
            }
        }

        // 最后交换 nums[l] 和 小于 v nums[lt] 的值
        swap(nums, l, lt);
        // 递归处理小于 v 的值
        sort(nums, l, lt - 1);
        // 递归处理大于 v 的值
        sort(nums, gt, r);

    }
    public static int findKthLargest(int[] nums, int k) {
        sort(nums);
        return 0;
    }
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

    }
}
