package com.example.ting.datastruct_test;

/**
 * Created by Ting on 2016/4/21.
 */
public class bubblesort_test {
    public static void bubblesort(int[] number)
    {
        int temp;int change = 0;
        int size = number.length;
        for (int i = 0;i < size-1;i++) {
            for (int j = 0;j < size-i-1;j++) {
                if(number[j] >= number[j+1])
                {  temp = number[j];
                   number[j] = number[j+1];
                   number[j+1] = temp;
                    change++;
                }
                if (change == 0) break;
                else change = 0;
            }

        }

    }
}
