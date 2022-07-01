package com.example.demo.alg;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 6/26/2022 10:20 PM
 */
public class Merge {
    /**
     * 辅助数组
     */
    private static int[] aux;

    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr,0, arr.length-1);
    }
    /**
     * 自顶向下方案
     * @param arr
     * @param low
     * @param high
     */
    public static void sort(int[] arr,int low,int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high-low)/2;
        sort(arr,low,mid);//对左边排序
        sort(arr,mid+1,high);//对右边排序
        merge(arr,low,mid,high);//合并两个数组
    }

    /**
     * 自底向上方案
     * @param arr
     */
    public static void sort2(int[] arr) {
        int len = arr.length;
        aux = new int[len];
        for (int size = 1;size <len;size = size + size) {
            for (int low = 0;low<len-size;low += size + size) {
                merge(arr,low,low+size-1,Math.min(low+size+size-1,len-1));
            }
        }
    }




    public static void merge(int[] arr,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        //将数据复制到辅助数组中
        for (int k = low;k<=high;k++) {
            aux[k] = arr[k];
        }
        //合并到原数组arr中
        for (int k = low;k<=high;k++) {
            if (i > mid) { //左边数组用完
                arr[k] = aux[j++];
            } else if (j > high) { // 右边数组用完
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,5,1,3,2};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
