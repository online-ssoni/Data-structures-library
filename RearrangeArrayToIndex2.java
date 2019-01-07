/*
Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and `j < i`
*/

import java.util.*;

public class RearrangeArrayToIndex2{
    public static int[] rearrange(int arr[], int len){
        Arrays.sort(arr);
        int newArr[] = new int[len];
        int arr_index = 0;
        int newArr_index = len-1;
        while(newArr_index >= 0){
            newArr[newArr_index] = arr[arr_index];
            newArr_index -= 2;
            arr_index++;
        }
        if(len%2 == 0){
            newArr_index = 0;
        }
        else{
            newArr_index = 1;
        }

        while(newArr_index >= 0 && arr_index < len){
            newArr[newArr_index] = arr[arr_index];
            newArr_index += 2;
            arr_index++;
        }
        return newArr;
    }
    public static void main(String[]args){
        int arr[] = {9,8,7,6,5,4,3,2,1};
        int len = arr.length;

        arr = rearrange(arr, len);

        System.out.println(Arrays.toString(arr));
    }
}
