public class MoveZeroesToEnd {
    /*
    // Naive approach
    // Create a temporary array and move all elements to the left, 
    // and fill the remaining with 0's
    static void pushZerosToEnd(int[] arr){
        ArrayList<Integer> temp = new ArrayList<>();
        // Copy non zero elements to a temporary array
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }

        int nz = temp.size();
        // Copy them back
        for(int i = 0; i<nz; i++){
            arr[i] = temp.get(i);
        }

        // Fill the rest with 0's
        for(int i = nz; i<arr.length; i++){
            arr[i] = 0;
        }
    }
    */

    // Optimal time 2 pointers
    // The pointer j will point to the first 0 in the array and i will
    // point to the next index
    static void pushZerosToEnd(int[] arr){
        int left = 0;
        int right = 0;
        while(left<arr.length){
            if(arr[left] != 0){
                arr[right] = arr[left];
                right++;
            }
            left++;
        }
        // Dont forget to fill the rest of the index with 0
        while(right<arr.length){
            arr[right] = 0;
            right++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
