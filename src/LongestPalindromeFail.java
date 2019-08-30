import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestPalindromeFail {


    public static void main(String[] args) {
//        String s = "asdfgfdsawerqweodsgfasdfasfd";
//        String s = "aaaaaa";
//        String s = "a";
//        String s = "bb";
        String s = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        System.out.println(longestPalindrome(s));
    }


    private static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] arrChar = s.toCharArray();
        if (arrChar.length > 1000) {
            System.out.println("invalid input string");
            return "";
        }
        List<String> results = new ArrayList<>();
        if (arrChar.length >= 2) {
            if (arrChar[0] == arrChar[1]) {
                results.add(arrChar[0] + "" + arrChar[1] + "");
            }
            if (arrChar[arrChar.length - 1] == arrChar[arrChar.length - 2]) {
                results.add(arrChar[arrChar.length - 2] + "" + arrChar[arrChar.length - 1] + "");
            }
        }
        for (int i = 1; i < arrChar.length - 1; i++) {
            String matchOddString = oddLength(i, arrChar);
            if (matchOddString != null) {
                results.add(matchOddString);
            }
            String matchEvenString = evenLength(i, arrChar);

            if (matchEvenString != null) {
                results.add(matchEvenString);
            }
        }

        String result = arrChar[0] + "";
        for (String r : results) {
            if (r.length() > result.length()) {
                result = r;
            }
        }
        return result;
    }

    private static String oddLength(int index, char[] arrChar) {
        String matchStringInit = arrChar[index] + "";
        int prev = index - 1;
        int next = index + 1;
        return getString(arrChar, matchStringInit, prev, next);
    }

    private static String evenLength(int index, char[] arrChar) {
        int prev = index;
        int next = index + 1;
        if (arrChar[prev] == arrChar[next]) {
            String matchStringInit = arrChar[prev] + "" + arrChar[next];
            prev--;
            next++;
            return getString(arrChar, matchStringInit, prev, next);
        }
        return null;
    }

    private static String getString(char[] arrChar, String matchString, int prev, int next) {
        while (prev >= 0 && next < arrChar.length) {
            if (arrChar[prev] == arrChar[next]) {
                matchString = arrChar[prev] + matchString + arrChar[next];
            } else {
                break;
            }
            prev--;
            next++;
        }
        if (matchString.length() > 1) {
            return matchString;
        }
        return null;
    }
}
