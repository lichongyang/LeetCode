import java.util.Arrays;

/**
 * 给定一个数组，找出数组中三个数之和最接近target的值
 * @author lz
 * nums：数字数字
 * target：目标值
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++){
			int low = i + 1, high = nums.length - 1;
			while (low < high){
				int sum = nums[i] + nums[low] + nums[high];
				if ( (Math.abs(target - sum)) < (Math.abs(target - result)) )
						//如果当前的和值更接近target则更新result
						result = sum;
				if (sum > target)
					//和数大于target要寻找更接近的，应使和数减少，即high应该减少，使加数减少
					high--;
				else
					low++;
			}
		}
		return result;
    }
}
