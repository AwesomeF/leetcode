import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        String s = "ab";
        List<Integer> result = getPartitionLabelLength(s);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    /*
    private static List<Integer> getPartitionLabelLength(String s) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(1);
            return result;
        }
        List<String> partitionStringList = new ArrayList<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            partitionStringList.add(c + "");
        }

        List<String> mergeStringList = new ArrayList<>();
        mergeStringList.add(partitionStringList.get(0));
        int index = 1;
        while (index < charArr.length) {
            boolean merged = false;
            for (int j = 0; j < mergeStringList.size(); j++) {
                if (mergeStringList.get(j).contains(charArr[index] + "")) {
                    List<String> newPartitionStringList = new ArrayList<>();
                    for (int m = 0; m < j; m++) {
                        newPartitionStringList.add(mergeStringList.get(m));
                    }
                    StringBuilder mergeString = new StringBuilder();
                    for (int k = j; k < mergeStringList.size(); k++) {
                        mergeString.append(mergeStringList.get(k));
                    }
                    mergeString.append(charArr[index]);
                    newPartitionStringList.add(mergeString.toString());
                    mergeStringList = newPartitionStringList;
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                mergeStringList.add(charArr[index] + "");
            }
            index++;

        }
        for (String s1 : mergeStringList) {
            result.add(s1.length());
        }
        return result;
    }
     */
    private static List<Integer> getPartitionLabelLength(String S) {

        // 记录每个字母最后一次在字符串中出现的位置
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            last.put(S.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        // preIndex表示上个区间的右端点
        // maxIndex表示当前遍历的字符右端点
        int preIndex = -1, maxIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = last.get(S.charAt(i));
            // 如果有更大值，则更新区间的右端点为更大值
            if (index > maxIndex) {
                maxIndex = index;
            }
            // 如果当前位置i等于当前所遍历的字符最后出现位置的最大值
            // 说明maxIndex即为区间的右端点
            if (i == maxIndex) {
                // 添加区间的长度
                result.add(maxIndex - preIndex);
                // 当前右端点变为上一区间右端点
                preIndex = maxIndex;
            }
        }
        return result;
    }
}
