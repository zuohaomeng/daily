package com.meng.daily.basejava.arithmetic;


import java.util.Arrays;
import java.util.Random;

/**
 * @author: 左浩
 * @date: Create in  2018/10/10-22:22
 */
public class Sort {
    private final static int LIST_LENGTH = 6;
    private static int[] aux;
    private static int[] list = {46,79,56,38,40,84};

    public static void main(String[] args) {
        Random random = new Random(49);
//        list = new int[LIST_LENGTH];
//        for (int i = 0; i < list.length; i++) {
//            list[i] = random.nextInt(100);
//        }

        System.out.println("原始的");
        printList();
//        Selection2();
//        Insertion2();
//        Shell2();
        //Merge2();
        Quick2();
        //现在的
        System.out.println("现在的");
        printList();
        System.out.println("是否有序: " + isSort());
    }

    /**
     * 二分查找
     */
    private static int rank2(int key) {
        return rank2(key, 0, LIST_LENGTH - 1);
    }

    private static int rank2(int key, int lo, int hi) {
        if (hi < lo) return -2;
        int mid = (lo + hi) / 2;
        if (key < list[mid]) {
            return rank2(key, lo, mid - 1);
        } else if (key > list[mid]) {
            return rank2(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    /**
     * 快排
     */
    private static void Quick2() {
        QuickSort2(0, LIST_LENGTH - 1);
    }
    private static void QuickSort2(int lo, int hi) {
        if(lo>=hi)
            return;
        int mid = partition(lo,hi);
        QuickSort2(lo,mid-1);
        QuickSort2(mid+1,hi);
    }

    private static int partition(int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int k = list[lo];
        while(true){
            while (list[++i]<=k) {
                if (i==hi)
                    break;
            }
            while(list[--j]>k){
                if(j==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(i,j);
            printList();
        }
        exch(j,lo);
        printList();
        return j;
    }
    /**
     * 归并排序
     */
    private static void Merge2() {
        aux = new int[LIST_LENGTH];
        Merge2(0, LIST_LENGTH - 1);
    }

    private static void Merge2(int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = (lo + hi) / 2;
        Merge2(lo, mid);
        Merge2(mid + 1, hi);
        MergeSort2(lo, mid, hi);
    }

    private static void MergeSort2(int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = list[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) list[k] = aux[j++];
            else if (j > hi) list[k] = aux[i++];
            else if (aux[i] <= aux[j]) list[k] = aux[i++];
            else list[k] = aux[j++];
        }

    }

    /**
     * 希尔排序
     */
    private static void Shell2() {
        int N = LIST_LENGTH;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (list[j] < list[j - h]) {
                        exch(j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }

    /**
     * 插入排序
     */
    private static void Insertion2() {
        for (int i = 1; i < LIST_LENGTH; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1])
                    exch(j, j - 1);
            }
        }
    }

    /**
     * 选择排序
     */
    private static void Selection2() {
        for (int i = 0; i < LIST_LENGTH - 1; i++) {
            int min = list[i];
            int k = i;
            for (int j = i + 1; j < LIST_LENGTH; j++) {
                if (min > list[j]) {
                    min = list[j];
                    k = j;
                }
            }
            if (k != i) {
                exch(k, i);
            }
        }
    }

    /**
     * 三向切分快排：适用于重复元素多的数组
     *
     * @param l
     * @param r
     */
    private static void quick3waySort(int l, int r) {
        if (l >= r) return;
        int i = l;  //保存小于
        int k = l + 1;//保存等于
        int j = r;//保存大于
        int temp = list[l];
        while (k <= j) {
            if (list[k] < temp) exch(k++, i++);
            else if (list[k] > temp) exch(k, j--);
            else k++;
        }
        quick3waySort(l, i - 1);
        quick3waySort(j + 1, r);
    }


    /**
     * 交换
     *
     * @param a
     * @param b
     */
    private static void exch(int a, int b) {
        int t = list[a];
        list[a] = list[b];
        list[b] = t;
    }

    /**
     * 输出所有数组
     */
    private static void printList() {
        System.out.println(Arrays.toString(list));
    }

    /**
     * 判断是否相等
     */
    private static boolean isSort() {
        for (int i = 0; i < LIST_LENGTH - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
