import java.util.Arrays;

public class DominantPairs {
    /*
    // Brute Approach
    int n = arr.length;
    int count = 0;
    for(int i =0; i<n/2; i++){
        for(int j = n/2; j<n; j++){
            if(arr[i] >= 5*arr[j])
            count++;
            }
            }
            return count;
            */
            
            // Optimal Approach 2 Pointers + Sorting
    static int dominantPairs(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr, 0, n/2);
        Arrays.sort(arr, n/2, n);
        int left = 0;
        int right = n/2;
        int count = 0;

        while(left<n/2){
            while(right<n && arr[left] >= 5*arr[right]){
                right++;
            }
            count+= (right - n/2);

            left++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {10, 2, 2, 1};

        System.out.println(dominantPairs(arr));
    }
}
