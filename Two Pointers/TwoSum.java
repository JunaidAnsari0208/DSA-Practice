import java.util.Arrays;

public class TwoSum {
    static boolean twoSum(int[] arr, int target){
    /*
        // Native Approach
        // Obvious generate all the possible combinations 
        // and check if it exists

        for(int i =0;i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target)
                    return true;
            }
        }
        return false;

        */
        /*
         // Better approach using hashing O(N) and O(N)
         HashSet<Integer> st = new HashSet<>();
         for(int i =0; i<arr.length; i++){
            int complement = target - arr[i];
            if(st.contains(complement))
            return true;
            st.add(arr[i]);
        }
        return false;
        */

        // Optimal Approach 2 Pointers? O(NlogN) and O(1)
        // First sort it
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum == target)
                return true;
            else if(sum<target)
                left++;
            else 
                right--;
        }

        return false;
     }

     public static void main(String[] args){

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;
      
        if (twoSum(arr, target))
            System.out.println("Cooked!");
        else
            System.out.println("Burnt!");
    }
}
