/*************************
 * ZigZag Conversion
 * ZigZag循环对角线结构
 * @author HP
 * 006
 *************************/


public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		char mid[][] = new char[numRows][1000];
		int i = 0, j = 0, k = 0;
		int state = 1; //1表示正向，0表示负向
		if (s.length() == 0 || numRows == 1)
			return s;
		while (i < s.length()){
			if (state == 1){
				for (j = 0; j < numRows && i < s.length(); j++){
					mid[j][k] = s.charAt(i);
					i++;
				}
				k++;
				state = 0;
			}
			if (state == 0){
				for (j = numRows - 2; j > 0 && i < s.length(); j--){
					mid[j][k] = s.charAt(i);
					i++;
					k++;
				}
				state = 1;
			}
		}
		for (i = 0; i < numRows; i++){
			for (int m = 0; m < k+1; m++){
				System.out.print(mid[i][m]+" ");
			}
			System.out.println();
		}
		String result = "";
		for (i = 0; i < numRows; i++){
			for (int m = 0; m < k+1; m++){
				if (mid[i][m] != 0){
					result += mid[i][m];
				}
			}
		}
		return result;
    }
	public static void main(String args[]){
		String s1 = convert("ABCD", 3);
		String string = convert("PAYPALISHIRING", 3);
		System.out.print(string);
	}
}
