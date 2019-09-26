import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNodeOperate {
 * int val;
 * TreeNodeOperate left;
 * TreeNodeOperate right;
 * TreeNodeOperate(int x) { val = x; }
 * }
 */

public class DeleteTreeNode {


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (null == root) {
            return forest;
        }
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        root = recursionDelNodes(root, forest, toDeleteSet);
        if (null != root) {
            forest.add(root);
        }
        return forest;

    }

    //递归
    public TreeNode recursionDelNodes(TreeNode root, List<TreeNode> forest, Set<Integer> toDeleteSet) {
        if (null == root) {
            return null;
        }
        root.left = recursionDelNodes(root.left, forest, toDeleteSet);
        root.right = recursionDelNodes(root.right, forest, toDeleteSet);
        if (toDeleteSet.contains(root.val)) {
            if (null != root.left) {
                forest.add(root.left);
            }
            if (null != root.right) {
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
