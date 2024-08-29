package T09找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: violet
 * Date: 2024/8/29 21:21
 */
public class Solution {

    /**
     * 我的方法 超时
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        int pLength = p.length();
        int left = 0;
        int right = left + pLength - 1;
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        List<Integer> integers = new ArrayList<>();
        LOOP: while (right < s.length()){
            ArrayList<Character> list = new ArrayList<>(pLength);
            for (int i = left; i <= right; i++){
                list.add(s.charAt(i));
            }
            Collections.sort(list);
            for (int i = 0; i < pLength; i++){
                if (pChars[i] != list.get(i)){
                    left++;
                    right++;
                    continue LOOP;
                }
            }
            integers.add(left);
            left++;
            right++;
        }
        return integers;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println();
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++){
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)){
            res.add(0);
        }
        for (int i = 0; i < sLen -pLen; i++){
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)){
                res.add(i + 1);
            }
        }
        return res;
    }
}
