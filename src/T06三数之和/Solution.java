package T06三数之和;

import org.junit.Test;

import java.util.*;

/**
 * Author: violet
 * Date: 2024/8/27 12:05
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1 - o2;
                            }
                        });
                        set.add(list);
                    }
                }
            }
        }
        for (List<Integer> integers : set) {
            lists.add(integers);
        }
        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
       int n = nums.length;
       Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        // 枚举a
        for (int first = 0; first < n; first++){
            // 需要和上一次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            // c对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = - nums[first];
            // 枚举b
            for (int second = first + 1; second < n; second++){
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                // 需要保证b的指针在c的指针的左侧
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);

                }
            }
        }
        return lists;
    }
}