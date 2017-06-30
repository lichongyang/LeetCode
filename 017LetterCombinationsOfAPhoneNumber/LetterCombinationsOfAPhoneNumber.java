import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 求电话键盘上数字对应英文
 * @author lz
 * 深度优先遍历
 */

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
    	String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	List<String> result = new ArrayList<>();
    	if (digits.length() == 0)
    		return result;
    	char[]  middleTemp = new char[digits.length()];
    	combineString(digits, middleTemp, 0, map, result);
    	return result;
    }
    
    public void combineString(String digits, char[] middleTemp, int index, String[] map, List<String> result){
    	if (index == digits.length()){
    		result.add(new String(middleTemp));
    		return;
    	}
    	String theString = map[Character.getNumericValue(digits.charAt(index))];
    	for (int i = 0; i < theString.length(); i++){
    		middleTemp[index] = theString.charAt(i);
    		combineString(digits, middleTemp, index + 1, map, result);
    	}
    }
}