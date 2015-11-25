/***********************************************************
 * Longest Palindromic Substring 最长回文字串
 * 第一次的方法（即注释掉的方法）是用矩阵记录相同字符的位置
 * 矩阵斜对角线上全为1对应位置构成的子字符串即为回文字串（但超时了）
 * @author HP
 * 005
 ***********************************************************/


public class PalindromicSubstring {
//	public static String longestPalindrome(String s) {
//		String mString = " ";
//		int left = 0;
//		int length = 1;
//		int sLength = s.length();
//		int state[][] = new int[sLength][sLength];
//		for (int i = 0; i < sLength; i++){
//			for (int j = 0; j < sLength; j++){
//				state[i][j] = 0;
//			}
//		}
//		if (s.length() == 0)
//			return mString;
//		if (s.length() == 1)
//			return s;
//		for (int i =0; i < sLength; i++){
//			for (int j = sLength - 1; j >= 0; j--){
//				if (s.charAt(i) == s.charAt(j)){
//					state[i][j] = 1;
//				}
//			}
//		}
//		for (int i = 0; i < sLength / 2; i++){
//			for (int j = 0; j < sLength; j++){
//				int count = 0;
//				int k = j;
//				int m = i;
//				while (m < sLength && k >= 0 && state[m][k] == 1){
//					count++;
//					m++;
//					k--;
//				}
//				if (count > length){
//					length = count;
//					left = i;
//				}
//			}
//		}
//		mString = s.substring(left, (left + length));
//		return mString;
//		
//	}
	public static String check(String s, int left, int right){
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}
	public static String longestPalindrome(String s) {
		String result = " ";
		int length = 1;
		if (s.length() == 0)
			return result;
		if (s.length() == 1)
			return s;
		for (int i = 0; i < s.length(); i++){
			String result1 = check(s, i, i);
			String result2 = check(s, i, i+1);
			if (result1.length() > length){
				result = result1;
				length = result.length();
			}
			if (result2.length() > length){
				result = result2;
				length = result.length();
			}
		}
		return result;
	}
	public static void main(String args[]){
		String s = "abababababababababa"
				+ "babababababababababababa"
				+ "bababababababababababababa"
				+ "babababababababababababababa"
				+ "bababababababababababababababa"
				+ "babababababababababababababababa"
				+ "bababababababababababababababababa"
				+ "babababababababababababababababababab"
				+ "abababababababababababababababababababab"
				+ "abababababababababababababababababababababab"
				+ "ababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababa"
				+ "bababababababababababa";
//		longestPalindrome(s);
		String result = longestPalindrome(s);
		System.out.println(result.length());
		System.out.println(result);
	}
}
