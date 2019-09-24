import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {

        String[] aSplit = A.split(" ");
        String[] bSplit = B.split(" ");
        HashMap<String, Integer> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String a : aSplit) {
            if ("".equals(a)) {
                continue;
            }
            if (countMap.containsKey(a)) {
                countMap.put(a, countMap.get(a) + 1);
            } else {
                countMap.put(a, 1);
            }
        }
        for (String b : bSplit) {
            if ("".equals(b)) {
                continue;
            }
            if (countMap.containsKey(b)) {
                countMap.put(b, countMap.get(b) + 1);
            } else {
                countMap.put(b, 1);
            }
        }

        for (String key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                result.add(key);
            }
        }
        return result.toArray(new String[0]);
    }
}
