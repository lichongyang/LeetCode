/*
 * 字符串数组的最长前缀，即每个字符串都含有该前缀
 * 取数组中第一个字符串作为初始前缀开始遍历，每次遍历使用当前遍历字符串与前缀字符串进行比较
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
     * 8ms答案
     */
    public String bestLongestCommonPrefix(String[] strs){
    	if (strs == null || strs.length == 0)
    		return null;
    	String pre = strs[0];
    	int i = 1;
    	while (i < strs.length){
    		//如果此方法传入的字符串参数发现这个对象内的子字符串，然后返回第一个此类子串的第一个字符的索引，如果它不发生的一个子串，则返回-1
    		while(strs[i].indexOf(pre) != 0)
    			//如果不等于零，则说明当前前缀不在当前遍历的字符串中。因为是前缀，故每次去除末位一个字符，直至当前前缀在所遍历字符串中
    			pre = pre.substring(0, pre.length() - 1);
    		i++;
    	}
    	return pre;
    } 
}
