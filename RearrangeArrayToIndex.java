/*
Rearrange an array such that arr[i] = i
*/
import java.util.*;
class RearrangeArrayToIndex{
    public static void rearrange(int arr[], int len){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<len; i++){
            if(arr[i] != -1){
                set.add(arr[i]);
            }
        }

        for(int i=0; i<len; i++){
            if(set.contains(arr[i])){
                arr[i] = i;
            }
            else{
                arr[i] = -1;
            }
        }
    }
    public static void main(String[]args){
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        int len = arr.length;

        rearrange(arr, len);

        System.out.println(Arrays.toString(arr));
    }
}
