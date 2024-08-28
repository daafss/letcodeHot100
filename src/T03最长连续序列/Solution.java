package T03最长连续序列;



import org.junit.Test;

import java.util.*;

/**
 * Author: violet
 * Date: 2024/8/25 21:01
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        HashSet<Integer> items = new HashSet<>();
        for (int num : nums) {
            items.add(num);
        }
        int max = 1;
        int current = 0;
        for (Integer item : items) {
            current = item;
            if (items.contains(item - 1)){
                continue;
            }
            while (items.contains(current + 1)){
                current++;
            }
            if (max < (current - item + 1)){
                max = (current - item + 1);
            }
        }
        return max;
    }
}
