import java.util.*;

/**
 * 给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："tcode"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 仅含有小写英文字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-substring-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastSubstring {

    /*
    public String getLastSubString(String s) {
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() - i; j++) {
                String newSubString = s.substring(i, i + j);
                if (!subStrings.contains(newSubString)) {
                    subStrings.add(newSubString);
                }
            }
        }
        Collections.sort(subStrings);
        return subStrings.get(subStrings.size() - 1);
    }
     */
    public String getLastSubString(String s) {
        if (s.length() == 1) {
            return s;
        }

        int currentMaxIndex = 0; //记录最大字符下标
        boolean needCompare = false; //是否有挑战者
        int newMaxIndex = 0; //挑战者下标
        for (int i = 1; i < s.length(); i++) { // 一次循环
            // 如何遍历的字符比当前字符还大，则最大字符下标变为当前下标
            if (s.charAt(i) > s.charAt(currentMaxIndex)) {
                currentMaxIndex = i;
                continue;
            }
            // 如果第一次出现挑战者，记录挑战者 （）
            if (s.charAt(i) == s.charAt(currentMaxIndex) && !needCompare) {
                newMaxIndex = i;
                needCompare = true;
                continue;
            }
            // 有挑战者时，如果挑战成功，则变更擂主
            if (needCompare) {
                if (s.charAt(i) > s.charAt(currentMaxIndex + i - newMaxIndex)) {
                    currentMaxIndex = newMaxIndex;
                    needCompare = false;
                }
            }
        }
        return s.substring(currentMaxIndex);
    }

}
