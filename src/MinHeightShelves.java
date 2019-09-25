import java.util.Arrays;

import static java.lang.Math.*;

/**
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 * <p>
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 * <p>
 * 按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 * <p>
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 * <p>
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 * <p>
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 * <p>
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * 输出：6
 * 解释：
 * 3 层书架的高度和为 1 + 3 + 2 = 6 。
 * 第 2 本书不必放在第一层书架上。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= books.length <= 1000
 * 1 <= books[i][0] <= shelf_width <= 1000
 * 1 <= books[i][1] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/filling-bookcase-shelves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinHeightShelves {
    //    public int minHeightShelves(int[][] books, int shelf_width) {
//        int totalHeight = 0;
//        int currentHeight = 0;
//        int currentWidth = 0;
//
//        for (int[] book : books) {
//            if (currentWidth + book[0] <= shelf_width) {
//                currentWidth = currentWidth + book[0];
//                currentHeight = max(currentHeight, book[1]);
//            } else {
//                totalHeight = totalHeight + currentHeight;
//                currentWidth = book[0];
//                currentHeight = book[1];
//            }
//        }
//        totalHeight = totalHeight + currentHeight;
//        return totalHeight;
//    }

    /**
     * 遍历每一本书，把当前这本书作为书架最后一层的最后一本书，将这本书之前的书向后调整，看看是否可以减少之前的书架高度。状态转移方程为 dp[i] = min(dp[i] , dp[j - 1] + h)，其中 j 表示最后一层所能容下书籍的索引的最小值，h 表示最后一层最大高度。
     *
     * 作者：smoon1989
     * 链接：https://leetcode-cn.com/problems/filling-bookcase-shelves/solution/dong-tai-gui-hua-python3-by-smoon1989/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param books
     * @param shelf_width
     * @return
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//作用是第一本书时 min(dp[i], dp[0] + height) 可得出dp[1]
        for (int i = 1; i <= books.length; i++) {
            int height = 0;
            int width = 0;
            int j = i;
            while (j > 0) {
                width += books[j - 1][0];
                if (width > shelf_width) {
                    break;
                }
                height = max(height, books[j - 1][1]);
                dp[i] = min(dp[i], dp[j - 1] + height);
                j--;
            }
        }

        return dp[dp.length - 1];

    }
}
