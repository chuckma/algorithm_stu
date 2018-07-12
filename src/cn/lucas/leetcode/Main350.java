package cn.lucas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lucas Ma
 */
public class Main350 {

    /**
     *
     * 给定两个数组，写一个方法来计算它们的交集。
     *
     * 例如:
     * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
     *
     * 注意：
     *
     *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     *    我们可以不考虑输出结果的顺序。
     *
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int aNums1 : nums1) {
            if (!map.containsKey(aNums1)) {
                map.put(aNums1, 1); // 如果不包含元素，添加该元素，并将其频次设置为1，
            } else {
                // 如果包含元素，则将其频次加 1，
                map.put(aNums1, map.get(aNums1) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int aNums2 : nums2) {
            if (map.containsKey(aNums2)) {
                // num2 中包含 元素，将该元素加入 list，并将map中对应该键的频次减去1
                // 比如示例中 程序在这里map 里就应该有两对键值 <1,2>,<2,2>
                list.add(aNums2);
                map.put(aNums2, map.get(aNums2) - 1);
                // 经过两次循环之后，最后一对键值就应该是 <2,0>
                if (map.get(aNums2) == 0) {// map中的元素循环完毕，交集已经加入 list
                    map.remove(aNums2);
                }
            }
        }


        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2,2,3};

        int[] res = new Main350().intersect(num1, num2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }

    }
}
