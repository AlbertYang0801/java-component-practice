package com.albert.sort.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 选择排序
 * 原理：每次排序选出最小的元素，替换到对应顺序的位置
 * 思路：第一次排序选出最小的元素，和第一位的元素进行交换
 *
 * @author yjw
 * @date 2020/9/13 23:46
 */
@Slf4j
public class ChooseSort {

    /**
     * 选择排序的思路：
     * 1.对所有元素进行遍历
     * 2.根据循环位次进行遍历，设置下标为循环位次
     * 3.将下标位置元素，与循环位次后的元素进行比较，若下标位置值大，则将比较位置下标替换为最小下标
     *
     * @param arr
     * @return
     */
    public static int[] choooseSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            //设置最小元素下标初始值
            int min = i;
            //选择出最小的值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    //设置最小元素下标位置
                    min = j;
                }
            }
            if (min != i) {
                //设置临时变量
                int temp;
                //交换最小元素与未排序的第一个元素
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            log.info("第{}次排序后的结果：{}", i, Arrays.toString(arr));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 9};
        int[] sortArr = choooseSort(arr);
        log.info(Arrays.toString(sortArr));
    }


}
