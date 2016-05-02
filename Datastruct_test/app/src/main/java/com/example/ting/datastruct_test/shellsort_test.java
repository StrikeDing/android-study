package com.example.ting.datastruct_test;

/**
 * Created by Ting on 2016/4/22.
 */
public class shellsort_test {

    public static void shellsort(int[] number)
    {
        int lo = number.length/2;
        int temp;
        for(;lo>=1;lo = lo/2)
        {
            for(int i = 0;i + lo < number.length; i = i + lo)
            {
                 if(number[i] > number[i + lo])
                 {
                     temp = number[i];
                     number[i] = number[i+1];
                     number[i+lo] = temp;
                 }
            }

        }

    }
}
