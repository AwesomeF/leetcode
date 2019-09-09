import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * <p>
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PathInZigZagTree {
    public static void main(String[] args) {

        List<Integer> pathInZigZagTree = new ArrayList<>();
//        int label = 14;
        int label = 26;
        int layer = getLastLayer(label);
        pathInZigZagTree.add(label);
        List<Integer> LayerLabels = getLayerLabel(layer);
        while (layer-- > 1) {
            int index = LayerLabels.indexOf(label);
            int parentLabelIndex = index / 2;
            List<Integer> prevLayerLabels = getLayerLabel(layer);
            int prevLabel = prevLayerLabels.get(parentLabelIndex);
            pathInZigZagTree.add(prevLabel);
            LayerLabels = prevLayerLabels;
            label = prevLabel;
        }
        System.out.println(pathInZigZagTree.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
    }


    private static int getLastLayer(int label) {
        if (label < 1) {
            return 0;
        }
        int stepResult = label;
        int layer = 1;
        while (stepResult >= 2) {
            stepResult = stepResult / 2;
            layer++;
        }
        return layer;
    }

    private static List<Integer> getLayerLabel(int layer) {
        List<Integer> result = new ArrayList<>();
        double start = Math.pow(2, layer - 1);
        double end = Math.pow(2, layer);
        for (int i = (int) start; i < (int) end; i++) {
            result.add(i);
        }
        if (layer % 2 == 0) {
            result.sort(Comparator.reverseOrder());
        }
        return result;
    }

}
