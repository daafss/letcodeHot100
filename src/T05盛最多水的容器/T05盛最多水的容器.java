package T05盛最多水的容器;

/**
 * Author: violet
 * Date: 2024/8/26 21:50
 */
class Solution {
    // 暴力求解
    public int maxArea(int[] height) {
        int maxVolume = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = i + 1; j < height.length; j++){
                int h = height[i] > height[j] ? height[j] : height[i];
                int volume = h * (j - i);
                if (maxVolume < volume){
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }

    // 官方求解
    public int maxArea2(int[] height) {
        int maxVolume = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int volume = 0;
            if (height[left] > height[right]){
                volume = (right - left) * height[right];
                right--;
                if (maxVolume < volume){
                    maxVolume = volume;
                }
            }else {
                volume = (right - left) * height[left];
                left++;
                if (maxVolume < volume){
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }
}