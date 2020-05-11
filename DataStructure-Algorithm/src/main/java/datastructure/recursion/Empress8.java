package datastructure.recursion;

/**
 * @author lhang
 * @create 2020-05-11 9:05
 */
public class Empress8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组arr，用于保存放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    int[] arr = new int[max];
    static int count = 0;
    static int judge = 0;

    public static void main(String[] args) {
        Empress8 empress8 = new Empress8();
        empress8.check(0);
        System.out.printf("一共%d中解法。\n", count);
        System.out.printf("一共判断冲突%d的次数。", judge);
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check 是每一次递归时，进入到check中都有for (int i = 0; i < max; i++)，因此会回溯
    private void check(int n) {
        if (n == max) {//n=8 ，其实八个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前的皇后n，放到改行的第一列
            arr[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后,开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n]=i;

        }

    }


    /**
     * 查看当我们放置第n个皇后的时候，就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judge++;
        for (int i = 0; i < n; i++) {
            //1.arr[i]==arr[n]  表示判断第n个皇后是否和前面的n-1个皇后在同一列。
            //2.Math.abs(n-i)==Math.abs(arr[n]-arr[i])  表示判断第n个皇后是否和第i个皇后在同一斜线。
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后摆放的位置，打印出来
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
