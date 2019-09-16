/**
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
 * <p>
 *  
 * <p>
 * 游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
 * <p>
 * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
 * <p>
 * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
 * <p>
 * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
 * <p>
 *  
 * <p>
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 * <p>
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 * <p>
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 * <p>
 *  
 * <p>
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * 输出：True
 * 解释：第二个玩家可以选择值为 2 的节点。
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的根节点为 root，树上由 n 个节点，节点上的值从 1 到 n 各不相同。
 * n 为奇数。
 * 1 <= x <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-coloring-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BtreeGameWinningMove {
    private static TreeNode firstPlayerNode = null;
    private static int leftChildrenNodeCount = 0;
    private static int rightChildrenNodeCount = 0;

    public static void main(String[] args) {
        TreeNode node = initTreeNode(11);
        System.out.println(btreeGame(node, 11, 4));
    }

    private static TreeNode initTreeNode(int length) {
        TreeNode[] nodeList = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            nodeList[i] = new TreeNode(i + 1);
        }
        if (length == 1) {
            return nodeList[0];
        }
        int parentNodeIndex = 0;
        int currentNodeIndex = 1;

        while (currentNodeIndex < length) {
            if (currentNodeIndex % 2 == 1) {
                nodeList[parentNodeIndex].left = nodeList[currentNodeIndex++];
            } else {
                nodeList[parentNodeIndex].right = nodeList[currentNodeIndex++];
                parentNodeIndex++;
            }
        }
        return nodeList[0];
    }

    private static boolean btreeGame(TreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }

        findTreeNode(root, x);
        leftRecursionPreloaderTraversal(firstPlayerNode.left);
        rightRecursionPreloaderTraversal(firstPlayerNode.right);

        int parentNodeCount = n - leftChildrenNodeCount - rightChildrenNodeCount - 1;
        return parentNodeCount > (n >> 1) || leftChildrenNodeCount > (n >> 1) || rightChildrenNodeCount > (n >> 1);

    }

    private static void findTreeNode(TreeNode root, int x) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            firstPlayerNode = root;
            return;
        }
        findTreeNode(root.left, x);
        findTreeNode(root.right, x);
    }

    private static void leftRecursionPreloaderTraversal(TreeNode root) {
        if (root != null) {
            leftChildrenNodeCount++;
            leftRecursionPreloaderTraversal(root.left);
            leftRecursionPreloaderTraversal(root.right);
        }
    }

    private static void rightRecursionPreloaderTraversal(TreeNode root) {
        if (root != null) {
            rightChildrenNodeCount++;
            rightRecursionPreloaderTraversal(root.left);
            rightRecursionPreloaderTraversal(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
