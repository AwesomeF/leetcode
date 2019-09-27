import java.util.Stack;


/**
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 * <p>
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 * <p>
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 * <p>
 *  
 * <p>
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 * <p>
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 * <p>
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 * <p>
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.size <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * ####思路：
 *
 * 遍历seq，遇到(则压入栈
 * 遇到)则计算：
 * 使用stack.size()获取当前深度
 * 当前遍历stack.pop()和i 获取括号的左右下标
 * depth%2 判断负责为1 还是0
 *
 * 作者：huangzhouwu
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/java-yi-ge-zhan-jie-fa-by-huangzhouwu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.isEmpty()) {
            return new int[0];
        }
        int[] result = new int[seq.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                stack.push(i);
            } else {
                int depth = stack.size();
                int left = stack.pop();
                if (depth % 2 == 0) {
                    result[left] = 1;
                    result[i] = 1;
                }
            }
        }
        return result;
    }
//    public int[] maxDepthAfterSplit(String seq) {
//        if (seq == null || seq.isEmpty()) {
//            return new int[0];
//        }
//        int[] result = new int[seq.length()];
//        Stack<Integer> stack = new Stack<>();
//        HashMap<Integer, Set<Integer>> depthIndexMap = new HashMap<>();
//        for (int i = 0; i < seq.length(); i++) {
//            if (seq.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                int depth = stack.size();
//                int left = stack.pop();
//                Set<Integer> updatingSet = depthIndexMap.getOrDefault(depth, new HashSet<>());
//                updatingSet.add(left);
//                updatingSet.add(i);
//                depthIndexMap.put(depth, updatingSet);
//            }
//        }
//        Set<Integer> aSet = new HashSet<>();
//        for (int i = 0; i < depthIndexMap.size() / 2; i++) {
//            aSet.addAll(depthIndexMap.get(i + 1));
//        }
//        for (int i = 0; i < seq.length(); i++) {
//            if (aSet.contains(i)) {
//                result[i] = 0;
//            } else {
//                result[i] = 1;
//            }
//        }
//        return result;
//    }
}
