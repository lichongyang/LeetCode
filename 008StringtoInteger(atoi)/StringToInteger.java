public class StringToInteger {
    public int myAtoi(String str) {
       if (str.length() == 0)
        	return 0;
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        int index = 0;
        long result = 0;
        int sigin = 1;
        while ((str.charAt(index) == ' ') && index < str.length())
        	index++;
        if ((str.charAt(index) == '+' || str.charAt(index) == '-') && index < str.length()){
        	sigin = (str.charAt(index) == '+') ? +1 : -1;
        	index++;
        }
        while (index < str.length()){
        	if (str.charAt(index) > '9' || str.charAt(index) < '0')
        		break;
        	result = result * 10 + Integer.parseInt(String.valueOf(str.charAt(index)));
        	if (result > MAX){
        		return (sigin == 1) ? MAX : MIN;
        	}
        	index++;
        }
        return (int)(result * sigin);
    }
}