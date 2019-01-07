/*
Given a sorted and rotated array, find if there is a pair with a given sum
*/

class PairOfSumInSortedAndRotatedArray{
    public static int getPivot(int arr[], int len){
        for(int i=0; i<len; i++){
            if(arr[i] > arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }
    public static void printPairOfSum(int arr[], int len, int sum){
        int pivot = getPivot(arr, len);
        int firstIndex = pivot+1;
        int lastIndex = pivot;

        while(firstIndex != lastIndex){
            int tempSum = arr[firstIndex] + arr[lastIndex];
            if(tempSum == sum){
                System.out.println(arr[firstIndex] + " + " + arr[lastIndex] + " = " + sum);
                firstIndex = (firstIndex+1)%len;
                lastIndex = (len + lastIndex - 1)%len;
            }
            else if(tempSum < sum){
                firstIndex = (firstIndex+1)%len;
            }
            else{
                lastIndex = (len + lastIndex - 1)%len;
            }
        }
    }
    public static void main(String[]args){
        int arr[] = {11, 15, 26, 38, 9, 10};
        int sum = 35;
        int len = arr.length;

        printPairOfSum(arr, len, sum);
    }
}
