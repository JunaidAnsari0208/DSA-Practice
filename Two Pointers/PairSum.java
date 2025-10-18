import java.util.HashSet;

public class PairSum {
    static boolean pairInSortedRotated(int[] arr, int target){
        /*
        // Brute Approach
        int n = arr.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] + arr[j] == target)
                return true;
            }
        }
        return false;
        */

        // Better Approach Hashing
        HashSet<Integer> st = new HashSet<>();

        for(int i =0; i<arr.length; i++){
            int complement = target - arr[i];
            if(st.contains(complement)){
                return true;
            }
            st.add(arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;

        if (pairInSortedRotated(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
