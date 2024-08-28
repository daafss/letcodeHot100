package T08无重复字符的最长字串;

import org.junit.Test;

import java.util.HashSet;

/**
 * Author: violet
 * Date: 2024/8/28 21:47
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0){
            return 0;
        }
        int maxSub = 1;
        for (int i = 0; i < chars.length - 1; i++){
            int a = i;
            int b = i+1;
            if (chars[a] == chars[b]){
                continue;
            }
            HashSet<Character> set = new HashSet<>();
            set.add(chars[a]);
            while (b <= chars.length - 1){
                if (!set.contains(chars[b])){
                    set.add(chars[b]);
                    b++;
                }else {
                    break;
                }
            }
            if (maxSub < b - a){
                maxSub = b - a;
            }
        }
        return maxSub;
    }

    public static void main(String[] args) {
        String s = "ab";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
