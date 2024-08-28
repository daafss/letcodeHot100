package T02字母异位分组;

import java.util.*;

/**
 * Author: violet
 * Date: 2024/8/24 21:14
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return null;
        }

        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!hashMap.containsKey(key)){

                List<Integer> value = new ArrayList<>();
                value.add(i);
                hashMap.put(key, value);
            }else {
                List<Integer> value = hashMap.get(key);
                value.add(i);
                hashMap.put(key, value);
            }
        }
        Set<String> keys = hashMap.keySet();
        List<List<String>> list = new ArrayList<>();
        for (String key : keys) {
            List<Integer> values = hashMap.get(key);
            List<String> list1 = new ArrayList<>();
            for (Integer value : values) {
                list1.add(strs[value]);
            }
            list.add(list1);
        }
        return list;
    }
}