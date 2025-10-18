import java.util.Arrays;

public class TwoEqualsThird {
    public static boolean findTriplet(int[] arr) {
        // Brute Approach
        // Basically 3 loops and we check individually
        // int n = arr.length;

        // for(int i = 0; i<n; i++){
        //     for(int j = i+1; j<n; j++){
        //         for(int k = j+1; k<n; k++){
        //             if(arr[i] + arr[j] == arr[k] || 
        //             arr[j] + arr[k] == arr[i] ||
        //             arr[k] + arr[i] == arr[j])
        //                 return true;
        //         }
        //     }
        // }
        // return false;

        int n = arr.length;
        Arrays.sort(arr);

        for(int i = 2; i<n; i++){
            int left = 0;
            int right = i-1;
            while(left<right){
                int sum = arr[left] + arr[right];
                if(sum == arr[i])
                    return true;
                else if(sum <arr[i])
                    left++;
                else
                    right--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        if (findTriplet(arr))
            System.out.println("true");
        else
            System.out.println("false");
    }
    
}
