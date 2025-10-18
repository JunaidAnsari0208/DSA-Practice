import java.util.HashSet;

public class removeDuplicatesFromSortedArray {
    static int removeDuplicates(int[] arr){
        // Brute force way so we have to remove dupes
        // Use HashSet

        // Declare a HashSet
        HashSet<Integer> st = new HashSet<>();
        // Now iterate and add all the elements from the array
        int n = arr.length;
        for(int i = 0; i<n; i++){
            st.add(arr[i]);
        }

        // Now find its size and put them back in the array and return it
        int k = st.size();
        int j = 0;
        for(int x : st){
            arr[j++] = x;
        }
        return k;
    } 
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = removeDuplicates(arr);

        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
