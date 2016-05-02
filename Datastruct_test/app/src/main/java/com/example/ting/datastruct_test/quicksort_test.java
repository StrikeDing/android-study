package com.example.ting.datastruct_test;

/**
 * Created by Ting on 2016/4/21.
 */
public class quicksort_test {
   public static void quicksort(int[] number,int start,int end)
   {
       int i = start;
       int j = end;
       int temp = 0;
       int base = number[start];
       while (i < j)
       {
           while(i < j && number[j] >= base)  j--;
           if (i < j) {
               temp = number[j];
               number[j] = number[i];
               number[i] = temp;
               i++;
           }
           while (i < j && number[i] <= base) i++;
           if (i < j) {
               temp = number[i];
               number[i] = number[j];
               number[j] = temp;
               j--;
           }
       }
       if (i > start) quicksort(number,start,i-1);
       if (j < end) quicksort(number,i+1,end);

       }

   }

