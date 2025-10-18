import java.util.Arrays;

public class ThreeSum {
    static boolean hasTripletSum(int[] arr, int target) {
        // Brute is 3 loops not gonna write it, I can do it
        // Better is HashSet 

        // int n = arr.length;
        // for(int i =0; i<n; i++){
        //     HashSet<Integer> st = new HashSet<>();
        //     for(int j = i+1; j<n; j++){
        //         int second = target - arr[i] - arr[j];
        //         if(st.contains(second)){
        //             return true;
        //         }
        //         st.add(arr[j]);
        //     }
        // }
        // return false;

        int n = arr.length;
        Arrays.sort(arr);
        
        // Fix the first element as arr[i]
        for (int i = 0; i < n - 2; i++) {
            
            // Initialize left and right pointers with 
            // start and end of remaining subarray
            int l = i + 1, r = n - 1;
            
            int requiredSum = target - arr[i];
            while (l < r) {
                if (arr[l] + arr[r] == requiredSum)
                    return true;
                if (arr[l] + arr[r] < requiredSum)
                    l++;
                else if (arr[l] + arr[r] > requiredSum)
                    r--;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        if (hasTripletSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
