package com.example.demo.alg;

/**
 * @author chenlingl
 * @version 1.0
 * @description 快速排序实现
 * @date 6/28/2022 10:47 PM
 */
public class Quick {
    public static void sort(int[] arr) {
        sort(arr,0, arr.length-1);
    }
    public static void sort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        //选择临界值
        int index = partition(arr, low, high);
        sort(arr, low, index - 1);
        sort(arr, index + 1, high);
    }

    /**
     * 选择临界值,
     *
     * @param arr
     * @param low
     * @param high
     */
    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = i + 1;
        for (int k = j; k <= high; k++) {
            //交换
            if (arr[k] < arr[i]) {
                swap(arr,k,j);
                j++;
            }
        }
        swap(arr,i,j-1);
        return j-1;
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,4};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
