package T10和位k的子数组;

/**
 * Author: violet
 * Date: 2024/8/29 22:08
 */
public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = nums[i];
            if (nums[i] == k){
                num++;
            }else {
                for (int j = i + 1; j < nums.length; j++){
                    sum = sum + nums[j];
                    if (sum == k){
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int end = 0; end < nums.length; end++){
            int sum = 0;
            for (int start = end; start >= 0; start--){
                sum = sum + nums[start];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum3(int[] nums, int k) {
        int count = 0;
        for (int end = 0; end < nums.length; end++){
            int sum = 0;
            for (int start = end; start >= 0; start--){
                sum = sum + nums[start];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
