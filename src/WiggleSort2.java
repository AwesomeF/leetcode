import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class WiggleSort2 {
    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 1, 1, 6, 4};
//        int[] input = new int[]{0, 1, 2, 3, 4};
//        int[] input = new int[]{2, 3, 3, 2, 2, 2, 1, 1};
        wiggleSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        int insetIndex = 0;
        int sourceInsetIndex = (length % 2 == 0) ? length / 2 - 1 : length / 2;
        while (sourceInsetIndex > insetIndex) {
            //较小部分插入排序
            insert(nums, insetIndex, sourceInsetIndex);
            insetIndex++;
            //较大部分插入排序
            insert(nums, insetIndex, length - 1);
            insetIndex++;
            sourceInsetIndex++;
        }
    }

    private static void insert(int[] nums, int insetIndex, int sourceInsetIndex) {
        int temp = nums[sourceInsetIndex];
        if (sourceInsetIndex - insetIndex > 0)
            System.arraycopy(nums, insetIndex, nums, insetIndex + 1, sourceInsetIndex - insetIndex);
        nums[insetIndex] = temp;
    }


}
