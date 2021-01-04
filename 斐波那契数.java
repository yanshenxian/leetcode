/* 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。

 

示例 1：

输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
示例 2：

输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2
示例 3：

输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 

提示：

0 <= n <= 30


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fibonacci-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class 斐波那契数 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int fa = 0;
        int fb = 0;
        int fc = 1;
        for (int i = 2; i <= n; i++) {
            fa = fb;
            fb = fc;
            fc = fa + fb;
        }

        return fc;
    }

    // public int fib(int n) {
    //     if (n < 2) {
    //         return n;
    //     }

    //     return fib(n - 1) + fib(n - 2);
    // }

    public static void main(String[] args) {
        斐波那契数 instance = new 斐波那契数();

        assert instance.fib(0) == 0;
        assert instance.fib(1) == 1;
        assert instance.fib(2) == 1;
        assert instance.fib(3) == 2;
        assert instance.fib(4) == 3;
        assert instance.fib(5) == 5;
        assert instance.fib(6) == 8;
        assert instance.fib(7) == 13;

        // java -ea 斐波那契数.java
    }


}