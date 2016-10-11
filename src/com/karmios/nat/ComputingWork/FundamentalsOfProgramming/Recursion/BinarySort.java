package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nat on 06/10/2016.
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 8, 1, 2, 3, 9, 0, 4};
        sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int index) {
        if (index == arr.length) return;
        int min = minIndex(arr, index);
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
        sort(arr, index+1);
    }

    static int minIndex(int[] arr, int start) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        int i = start;
        do {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
            i++;
        } while(i<arr.length);

        return index;
    }

}
