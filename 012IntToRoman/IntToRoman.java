
public class IntToRoman {
	public static String compose(int num, String roman){
		String result = "";
		for (int i = 0; i < num; i++){
			result += roman;
		}
		return result;
	}
	public String intToRoman(int num) {
		int[] index = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    String result = "";
	    for (int i = 0; i < index.length; i++){
	    	result += compose(num / index[i], roman[i]);
	    	num = num - (index[i] * (num / index[i]));
	    }
	    return result;
	}
}
