package com.example.ting.datastruct_test;

/**
 * Created by Ting on 2016/4/22.
 */
public class Mergasort_test {
    public static void Mergasort(int[] number,int start,int end)
    {
      if(end > start)
      {
          int middle = (start + end)/2;
          Mergasort(number,start,middle);
          Mergasort(number,middle+1,end);
          Merga(number,start,middle,end);
      }

    }
    public static void Merga(int[] number,int start,int middle,int end)
    {
          int[] arr = new int[number.length];
          int mid = middle+1;
          int leng = start;
          while(start < middle && mid < end )
          {
              if(number[start]<number[mid])
                  arr[leng++] = number[start++];
              else
                  arr[leng++] = number[mid++];
          }
          while (start <= middle) arr[leng++] = number[start++];
          while (mid <= end) arr[leng++] = number[start++];
          int temp = start;
          while (start <= end) number[temp++] = arr[temp++];
          arr = null;
    }
}
