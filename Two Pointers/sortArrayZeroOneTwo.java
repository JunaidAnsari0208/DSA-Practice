public class sortArrayZeroOneTwo {
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr){
        /* 
        // Brute approach
        Arrays.sort(arr);
        */
        /* 
        // Better Approach
        // Take 3 variables and store the individual counts
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i =0; i<arr.length; i++){
            if(arr[i] == 0)
                cnt0++;
            else if(arr[i] == 1)
                cnt1++;
            else
                cnt2++;
        }

        // Place them back
        for(int i =0; i<cnt0; i++){
            arr[i] = 0;
        }
        for(int i = cnt0; i<cnt0 + cnt1; i++){
            arr[i] = 1;
        }
        for(int i = cnt0 + cnt1; i<arr.length; i++){
            arr[i] = 2;
        }
        */

        // Optimal Approach
        // Dutch National Flag Algo, which u still havent managed to remember 
        // After writing it for nearly 100 times
        // Anyways 1 more time

        // Divide into 3 regions, low, mid and high
        // 0 to low all 0's
        // low to mid all 1's
        // mid to high Uncertain or unsorted area
        // high to n all 2's

        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 0, 1, 2 };
        int n = a.length;

        sort012(a);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}