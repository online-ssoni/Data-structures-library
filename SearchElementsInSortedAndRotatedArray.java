/*
Search an element in a sorted and rotated array
*/
public class SearchElementsInSortedAndRotatedArray{
    public static int binarySearch(int arr[], int left, int right, int key){
        if(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(key > arr[mid]){
                return binarySearch(arr, mid+1, right, key);
            }
            if(key < arr[mid]){
                return binarySearch(arr, left, mid-1, key);
            }
        }
        return -1;
    }
    public static int getPivot(int arr[], int len){
        for(int i=1; i<len; i++){
            if(arr[i] > arr[i-1]){
                return arr[i-1];
            }
        }
        return 0;
    }
    public static int search(int arr[], int len, int key){
        int pivot = getPivot(arr, len);
        if(arr[pivot] == key){
            return pivot;
        }

        if(key >= arr[pivot+1] && key <= arr[len-1]){
            int position = binarySearch(arr, pivot+1, len-1, key);
            if(position != -1){
                return position;
            }
        }
        else if(key >= arr[0] && key <= arr[pivot-1]){
            int position = binarySearch(arr, 0, pivot-1, key);
            if(position != -1){
                return position;
            }
        }
        return -1;
    }
    public static void main(String []args){
        int arr[] = {5,6,7,8,9,10,1,2,3};
        int len = arr.length;
        int testCases[] = {5,6,7,8,9,10,1,2,3,53,-2,0};

        for(int i=0; i<testCases.length; i++){
            int key = testCases[i];
            int position = search(arr, len, key);
            if(position == -1){
                System.out.println(key + " not found");
            }
            else{
                System.out.println(key + " found at position "+position);
            }
        }
    }
}
