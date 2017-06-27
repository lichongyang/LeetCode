import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/*
 * 属于Ksum问题，如果使用暴力解法，即遍历3次，时间复杂度n*n*n，超时
 * 使用排序
 * 使用HashMap 
 */

public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length == 0){
    		return result;
    	}
    	for (int i = 0; i < nums.length; i++){
    		for (int j = i + 1; j < nums.length; j++){
    			for (int k = j + 1; k < nums.length; k++){
    				int sum = nums[i] + nums[j] + nums[k];
    				if (sum == 0){
    					List<Integer> midList = new ArrayList<>();
    					midList.add(nums[i]);
    					midList.add(nums[j]);
    					midList.add(nums[k]);
    					Collections.sort(midList);
    					result.add(midList);
    				}
    			}
    		}
    	}
    	HashSet h = new HashSet(result);
    	result.clear();
    	result.addAll(h);
    	return result;
    }
    /*
     * nums倍排序后，每次枚举时只需从后一个开始，即abcdef，第一次枚举a时，在剩下的bcdef中进行2sum，第二次枚举b时，只需在cdef中进行2sum
     * 因为，数组是有序的，以枚举过元素对应的情形，在上次枚举时已经全部找出，无需再查找
     */
    public List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length == 0){
    		return result;
    	}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++){
    		//不加此句，在数组中元素全为零时，会出现内存超出的情况
    		if (i > 0 && nums[i] == nums[i - 1])
    			//跳过相同元素，即对于以排序的数组，如果当前元素与前一元素相同，则说明已经进行过遍历
    			continue;
    		int target = 0 - nums[i];
    		int low = i + 1;
    		int high = nums.length - 1;
    		while (low < high){
    			int sum = nums[low] + nums[high];
    			if (sum == target){
    				List<Integer> midList = new ArrayList<>();
					midList.add(nums[i]);
					midList.add(nums[low]);
					midList.add(nums[high]);
					Collections.sort(midList);
					result.add(midList);
					/*
					 * 可以使用另一种方法避免结果的重复，跳过相同元素
					if (low < high && nums[low] == nums[low + 1])
						low++;
					if (low < high && nums[high] == nums[high - 1])
						high--;
					 */
					low++;
					high--;
    			}else if (sum < target){
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
