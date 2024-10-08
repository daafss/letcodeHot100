package T01两数之和;

/**
 * Author: violet
 * Date: 2024/8/24 20:52
 */

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class Solution {
    // 暴力枚举
    public int[] twoSum(int[] nums, int target) {
        int otherNum = 0;
        for (int i = 0; i < nums.length; i++){
            otherNum = target - nums[i];
            for (int j = 0; j < nums.length; j++){
                if (otherNum == nums[j]){
                    if (i != j){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }
}