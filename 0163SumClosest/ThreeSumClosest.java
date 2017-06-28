import java.util.Arrays;

/**
 * ����һ�����飬�ҳ�������������֮����ӽ�target��ֵ
 * @author lz
 * nums����������
 * target��Ŀ��ֵ
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
						//�����ǰ�ĺ�ֵ���ӽ�target�����result
						result = sum;
				if (sum > target)
					//��������targetҪѰ�Ҹ��ӽ��ģ�Ӧʹ�������٣���highӦ�ü��٣�ʹ��������
					high--;
				else
					low++;
			}
		}
		return result;
    }
}
