import java.util.Stack;

/**
 * 给定一个只有（）[]{}组成的字符串，求字符串是否合法
 * @author lz
 * （）[]合法，{（）}不合法
 * 利用堆栈
 */
public class ValidParentheses {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < s.length(); i++){
    		if (s.charAt(i) == '(')
    			//表示下一位置期望一个）
    			stack.push(')');
    		else if (s.charAt(i) == '[')
    			stack.push(']');
    		else if (s.charAt(i) == '{')
    			stack.push('}');
    		else if (stack.isEmpty() || stack.pop() != s.charAt(i) )
    			return false;
    	}
    	return stack.isEmpty();
    }
}
