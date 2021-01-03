import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/* 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]
 

提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */

public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || k < 2) {
            return nums;
        }
        int[] results = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            
            deque.addLast(i);

            // 判断之前的最大值是否在当前窗口内
            if (deque.peek() < i - k + 1) {
                deque.remove();
            }
            // i 代表窗口的最右边
            if (i >= k - 1) {
                results[i + 1 - k] = nums[deque.peek()];
            }
        }

        return results;
    }

    public static void main(String[] args) {
        滑动窗口最大值 instance = new 滑动窗口最大值();

        // 测试用例1
        int[] nums1 = {1};
        int k1 = 1;
        assert Arrays.equals(new int[]{1}, instance.maxSlidingWindow(nums1, k1));

        // 测试用例2
        int[] nums2 = {1, -1};
        int k2 = 1;
        assert Arrays.equals(new int[]{1, -1}, instance.maxSlidingWindow(nums2, k2));

        // 测试用例3
        int[] nums3 = {9, 11};
        int k3 = 2;
        assert Arrays.equals(new int[]{11}, instance.maxSlidingWindow(nums3, k3));

        // 测试用例4
        int[] nums4 = {4, -2};
        int k4 = 2;
        assert Arrays.equals(new int[]{4}, instance.maxSlidingWindow(nums4, k4));

        // 测试 
        // java -ea 滑动窗口最大值.java
    }

}