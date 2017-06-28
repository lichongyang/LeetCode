import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 4 sum 问题类似于3 sum，将其不断退化为2sum
 * @author lz
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length == 0){
    		return result;
    	}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++){
    		if (i > 0 && nums[i] == nums[i - 1])
    			continue;
    		int threeSumTarget = target - nums[i];
    		int[] threeSumNums = Arrays.copyOfRange(nums, i + 1, nums.length);
    		List<List<Integer>> threeSumResult = new ArrayList<>();
    		threeSumResult = threeSum(threeSumNums, threeSumTarget, nums[i]);
    		if (threeSumResult != null){
    			result.addAll(threeSumResult);
    		}
    	}
    	HashSet h = new HashSet(result);
    	result.clear();
    	result.addAll(h);
    	return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int nowNums){
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length == 0){
    		return result;
    	}
    	for (int i = 0; i < nums.length - 2; i++){
    		if (i > 0 && nums[i] == nums[i - 1])
    			continue;
    		int theTarget = target - nums[i];
    		int low = i + 1, high = nums.length - 1;
    		while (low < high){
    			int sum = nums[low] + nums[high];
    			if (sum == theTarget){
    				List<Integer> midList = new ArrayList<>();
					midList.add(nums[i]);
					midList.add(nums[low]);
					midList.add(nums[high]);
					midList.add(nowNums);
					Collections.sort(midList);
					result.add(midList);
					low++;
					high--;
    			}else if (sum < theTarget){
    				low++;
    			}else{
    				high--;
    			}
    		}
    	}
    	HashSet h = new HashSet(result);
    	result.clear();
    	result.addAll(h);
    	return result;
    }
}
