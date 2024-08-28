package T01两数之和;

import java.util.HashMap;

/**
 * Author: violet
 * Date: 2024/8/24 21:04
 */
public class Solution2 {
    // 哈希表
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return null;
    }
}
