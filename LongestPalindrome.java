import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *         示例 1：
 *
 *         输入: "babad"
 *         输出: "bab"
 *         注意: "aba" 也是一个有效答案。
 *         示例 2：
 *
 *         输入: "cbbd"
 *         输出: "bb"
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestPalindrome {


    public static void main(String[] args) {
        String s = "asdfgfdsawerqweodsgfasdfasfd";
        System.out.println(longestPalindrome(s));
    }


    private static String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        char[] arrChar = s.toCharArray();
        if (arrChar.length > 1000) {
            System.out.println("invalid input string");
            return "";
        }
        List<String> results = new ArrayList<>();
        for (int i = 1; i < arrChar.length - 1; i++) {
            String matchString = arrChar[i] + "";
            int min = i - 1;
            int max = i + 1;
            while (min >= 0 && max <= 1000) {
                if (arrChar[min] == arrChar[max]) {
                    matchString = arrChar[min] + matchString + arrChar[max];
                } else {
                    break;
                }
                min--;
                max++;
            }
            if (matchString.length() > 1) {
                results.add(matchString);
            }
        }
        String result = "";
        for (String r : results) {
            if (r.length() > result.length()) {
                result = r;
            }
        }
        return result;
    }
}
