import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**************************************************************************
 * TwoSum �ҳ���������ӵ���Ŀ��ֵ�����������ҵ�һ����������С�ڵڶ�����
 * @author ����
 * 001
 *************************************************************************/

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2]; 
		int count=0;
		for (int i =0;i<nums.length;i++){
			for (int j=(i+1);j<nums.length;j++){
				if ((nums[i]+nums[j]) == target){
					result[0]=(i+1);
					result[1]=(j+1);
					return result;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int nums[] = {3, 2, 4};
		int result[] = twoSum(nums,6);
		if (result.length != 0){
			System.out.print("index1=" + result[0]+", index2="+result[1]);
		}
	}
}