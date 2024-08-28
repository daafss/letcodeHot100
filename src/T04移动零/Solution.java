package T04移动零;

import org.junit.Test;

import java.util.ArrayList;


/**
 * Author: violet
 * Date: 2024/8/26 21:18
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> zeroList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                numList.add(nums[i]);
            }else {
                zeroList.add(nums[i]);
            }
        }
        for (Integer zero : zeroList) {
            numList.add(zero);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }
    }

    @Test
    public void mov11eZeroes() {
        int[] nums = {0,1,0,3,12};
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
