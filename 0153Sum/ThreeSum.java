import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/*
 * ����Ksum���⣬���ʹ�ñ����ⷨ��������3�Σ�ʱ�临�Ӷ�n*n*n����ʱ
 * ʹ������
 * ʹ��HashMap 
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
     * nums�������ÿ��ö��ʱֻ��Ӻ�һ����ʼ����abcdef����һ��ö��aʱ����ʣ�µ�bcdef�н���2sum���ڶ���ö��bʱ��ֻ����cdef�н���2sum
     * ��Ϊ������������ģ���ö�ٹ�Ԫ�ض�Ӧ�����Σ����ϴ�ö��ʱ�Ѿ�ȫ���ҳ��������ٲ���
     */
    public List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length == 0){
    		return result;
    	}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++){
    		//���Ӵ˾䣬��������Ԫ��ȫΪ��ʱ��������ڴ泬�������
    		if (i > 0 && nums[i] == nums[i - 1])
    			//������ͬԪ�أ�����������������飬�����ǰԪ����ǰһԪ����ͬ����˵���Ѿ����й�����
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
					 * ����ʹ����һ�ַ������������ظ���������ͬԪ��
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
