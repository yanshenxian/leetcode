/* 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class 分隔链表 {
       
    // public ListNode partition(ListNode head, int x) {
    //     if (null == head || null == head.next) {
    //         return head;
    //     }

    //     ListNode lessNext = new ListNode(0);
    //     ListNode greaterNext = new ListNode(0);
    //     ListNode lessHead = lessNext;
    //     ListNode greaterHead = greaterNext;

    //     while (head != null) {
    //         int val = head.val;
    //         if (val < x) {
    //             lessNext.next = new ListNode(val);
    //             lessNext = lessNext.next;
    //         } else {
    //             greaterNext.next = new ListNode(val);
    //             greaterNext = greaterNext.next;
    //         }

    //         head = head.next;
    //     }

    //     lessNext.next = greaterHead.next;
    //     return lessHead.next;
    // }

    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        // 小于 x 的尾节点
        ListNode less = root;
        // 上一个节点
        ListNode pre = root;
        // 是否移位
        boolean tunned = false;
        while (head != null) {
            if (head.val < x) {
                ListNode next = head.next;
                if (tunned) {
                    // 发生了移位 把小的节点提到前面                
                    pre.next = next;
                    head.next = less.next;
                    less.next = head;
                    less = head;
                } else {
                    // 如果一直没有移位 小节点保持不动
                    less = head;
                }
                // 继续循环
                head = next;
            } else {
                tunned = true;
                pre = head;
                head = head.next;
            }
        }

        return root.next;
    }

}