import java.util.Stack;

/**
 * ����һ��ֻ�У���[]{}��ɵ��ַ��������ַ����Ƿ�Ϸ�
 * @author lz
 * ����[]�Ϸ���{����}���Ϸ�
 * ���ö�ջ
 */
public class ValidParentheses {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < s.length(); i++){
    		if (s.charAt(i) == '(')
    			//��ʾ��һλ������һ����
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
