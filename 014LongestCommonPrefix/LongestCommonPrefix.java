/*
 * �ַ���������ǰ׺����ÿ���ַ��������и�ǰ׺
 * ȡ�����е�һ���ַ�����Ϊ��ʼǰ׺��ʼ������ÿ�α���ʹ�õ�ǰ�����ַ�����ǰ׺�ַ������бȽ�
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return null;
    	String result = strs[0];
    	for (int i = 1; i < strs.length; i++){
    		result = compare(result, strs[i]);
    		if (result == "")
    			break;
    	}
        return result;
    }
    public String compare(String prefix, String s){
    	int length = 0;
    	int i = 0;
    	if (prefix.length() <= s.length()){
    		length = prefix.length();
    		while (i < length){
        		if (prefix.charAt(i) != s.charAt(i))
        			break;
        		else
        			i++;
        	}
    		if (i == 0)
    			return "";
    		else 
    			return prefix.substring(0, i);
    	}else{
    		length = s.length();
    		while (i < length){
        		if (prefix.charAt(i) != s.charAt(i))
        			break;
        		else
        			i++;
        	}
    		if (i == 0)
    			return "";
    		else 
    			return s.substring(0, i);
    	}
    }
    /*
     * 8ms��
     */
    public String bestLongestCommonPrefix(String[] strs){
    	if (strs == null || strs.length == 0)
    		return null;
    	String pre = strs[0];
    	int i = 1;
    	while (i < strs.length){
    		//����˷���������ַ�������������������ڵ����ַ�����Ȼ�󷵻ص�һ�������Ӵ��ĵ�һ���ַ����������������������һ���Ӵ����򷵻�-1
    		while(strs[i].indexOf(pre) != 0)
    			//����������㣬��˵����ǰǰ׺���ڵ�ǰ�������ַ����С���Ϊ��ǰ׺����ÿ��ȥ��ĩλһ���ַ���ֱ����ǰǰ׺���������ַ�����
    			pre = pre.substring(0, pre.length() - 1);
    		i++;
    	}
    	return pre;
    } 
}
