import java.util.Arrays;

public class CountPairsWithDiffK{
    static int countPairs(int[] arr, int k) {
        // Brute Approach
        // Generate all pairs and find out
        // int cnt = 0;
        // for(int i =0; i<arr.length; i++){
        //     for(int j = i+1; j<arr.length; j++){
        //         if(Math.abs(arr[i] - arr[j]) == k)
        //             cnt = cnt + 1;
        //     }
        // }
        // return cnt;

        // Better Approach 
        // 2 Pointer
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = 1, count = 0;

        while (j < n) {
            if (i == j) j++; // ensure j > i

            int diff = arr[j] - arr[i];

            if (diff == k) {
                count++;
                int val1 = arr[i], val2 = arr[j];

                // Skip duplicates for both sides
                while (i < n && arr[i] == val1) i++;
                while (j < n && arr[j] == val2) j++;
            } else if (diff > k) {
                i++;
            } else { // diff < k
                j++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;

        System.out.println(countPairs(arr, k));
    }
}