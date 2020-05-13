package datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序
 *
 * @author lhang
 * @create 2020-05-13 17:53
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        // 创建要给80000个的随机的数组
        int arrSize = 80000;
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int) (Math.random() * arrSize); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSortInsert(arr);//调用希尔排序移位式算法

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    //希尔排序——交换式
    public static void shellSortSwap(int[] arr) {
        int temp = 0;
        //
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                //遍历各组中所有的元素
                for (int j = i - step; j >= 0; j -= step) {
                    //如果当前元素大于加步长的那个元素，说明交换
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }

    }

    //希尔排序——移位式
    public static void shellSortInsert(int[] arr) {
        //增量step,并逐步的缩小增量
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //从step个元素开始，逐个对所在组进行直接插入排序
            for (int i = step; i < arr.length; i++) {
                int index = i;
                int indexValue = arr[index];
                if (arr[index] < arr[index - step]) {
                    while (index - step > 0 && indexValue < arr[index - step]) {
                        //移动
                        arr[index] = arr[index - step];
                        index -= step;
                    }
                    //退出while时，给indexvalue找到插入的位置
                    arr[index] = indexValue;
                }

            }
        }
    }
}
