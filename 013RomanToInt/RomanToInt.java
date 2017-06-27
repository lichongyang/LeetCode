/*
 * 罗马数字转数字
 * 小数在大数左边时，相减
 */
public class RomanToInt {
    public int romanToInt(String s) {
    	int result = charToInt(s.charAt(0));
    	for (int i = 1; i < s.length(); i++){
    		if (charToInt(s.charAt(i - 1)) < charToInt(s.charAt(i))){
    			//前数会出现重复加的情况，故剪去2倍
    			result += charToInt(s.charAt(i)) - 2 * charToInt(s.charAt(i - 1));
    		}else{
    			result += charToInt(s.charAt(i));
    		}
    	}
		return result;
    }
    public int charToInt(char c){
    	switch(c){
		case 'I':
			return 1;
		case 'X':
			return 10;
		case 'C':
			return 100;
		case 'M':
			return 1000;
		case 'V':
			return 5;
		case 'L':
			return 50;
		case 'D':
			return 500;
    	}
    	return 0;
    }
}
