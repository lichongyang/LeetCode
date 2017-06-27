public class PalindromeNumber {
    public static int reverse(int x) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        long result = 0;
        while (x != 0){
        	result = result * 10 + (x % 10);
        	if (result > MAX || result < MIN)
        	    result = 0;
        	x = x / 10;
        }
        return (int)result;
    }
    public boolean isPalindrome(int x) {
        if (x < 0)
			return false;
		if (x >= 0 && x <= 9)
			return true;
		long reverseInt = reverse(x);
		if (reverseInt != 0 && reverseInt == x)
			return true;
		return false;
    }
}