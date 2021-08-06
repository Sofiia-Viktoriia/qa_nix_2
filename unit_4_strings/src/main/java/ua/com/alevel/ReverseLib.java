package ua.com.alevel;

public class ReverseLib {
    public static String reverse(String src, boolean reverseAll) {
        String result = "";
        if (reverseAll) {
            for (int i = src.length() - 1; i >= 0; i--) {
                result = result.concat(String.valueOf(src.charAt(i)));
            }
        } else {
            String[] strs = src.split(" ");
            for (int j = 0; j < strs.length; j++) {
                result = result.concat(reverse(strs[j], true));
                if (j != strs.length - 1) {
                    result = result.concat(" ");
                }
            }
        }
        return result;
    }
}
