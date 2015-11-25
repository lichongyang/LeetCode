import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/********************************************************************************
 * Longest Substring Without Repeating Characters 字符串中没有重复字符的最长字串
 * @author 李重
 * 003
 ********************************************************************************/

public class three {
	
	public  static int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		int length = 0;
		int ptr = 0;
		for (int i = 1;i<s.length(); i++){
			int index = s.indexOf(s.charAt(i), ptr);
			if (index < i){
				ptr = index + 1;
			}
			length = Math.max(length, i-ptr+1);
		}
		return length;
    }
	
	public static void main(String[] args){
		String string = "dvdf";
		int length = lengthOfLongestSubstring(string);
		System.out.print(length);
	}
}
