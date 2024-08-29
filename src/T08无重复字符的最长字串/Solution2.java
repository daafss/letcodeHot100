package T08无重复字符的最长字串;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: violet
 * Date: 2024/8/28 22:17
 */
class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();//去重
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++){
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}