package cn.lucas.leetcode;

/**
 * @Author Lucas Ma
 */
public class Main3 {

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * 示例：
     *
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     *
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     *
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
     *
     *
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0,r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res, r - l + 1);
        }


        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Main3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Main3().lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(new Main3().lengthOfLongestSubstring("pwwkew"));
    }
}
