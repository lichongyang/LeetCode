/***********************
 * 007 Reverse Integer
 * ��Ҫ���ڿ����������Ĵ���
 * @author ����
 *
 */

public class ReverseInteger {
	public static int reverse(int x) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        long result = 0;
        while (x != 0){
        	result = result * 10 + (x % 10);
        	if (result > MAX || result < MIN)
            	return 0;
        	x = x / 10;
        }
        return (int)result;
    }
	public static void main(String args[]){
		int x = 1534236469;
		System.out.println(reverse(x));
	}
}
