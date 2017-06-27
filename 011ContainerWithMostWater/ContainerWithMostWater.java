public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
        	int calcualte_height = Math.min(height[left], height[right]);
        	int volume = (right - left) * calcualte_height;
        	if (volume > result)
        		result = volume;
        	if (height[left] < height[right])
        		left++;
        	else
        		right--;
        }
        return result;
    }
}