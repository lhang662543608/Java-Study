package datastructure.search;

/**
 * @author lhang
 * @create 2020-05-15 10:50
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, 23, 44, -2};//没有顺序的数组
        int i = seqSearch(arr, 11);
        if (i == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found,Array index is " + i);
        }

    }

    /**
     * 线性查找是逐一比对，发现有相同值，就返回下标。
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
