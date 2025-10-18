class GfG {
    static int maxWater(int[] arr) {
        /*
        // BRUTE APPROACH
        int res = 0;

        // For every element of the array
        for (int i = 1; i < arr.length - 1; i++) {

            // Find the maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);

            // Find the maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                right = Math.max(right, arr[j]);

            // Update the maximum water
            res += Math.min(left, right) - arr[i];
        }

        return res;
        */

        /*
        
        // BETTER APPROACH 
        // Prefix Sum
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        
        
        left[0] = arr[0];
        for(int i = 1; i<n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }
        
        right[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }
        
        for(int i = 1; i<n-1; i++){
            res += Math.min(left[i], right[i]) - arr[i];
        }
        
        return res;
        */

        // OPTIMAL APPROACH
        // 2 Pointer
        int left = 1;
        int right = arr.length - 2;

        int lMax = arr[left-1];
        int rMax = arr[right + 1];

        int res = 0;
        while (left <= right) {
            if(rMax <= lMax){
                res += Math.max(0, rMax - arr[right]);
                rMax = Math.max(rMax, arr[right]);
                right--;
            }else{
                res += Math.max(0, lMax - arr[left]);
                lMax = Math.max(lMax, arr[left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
    }
}